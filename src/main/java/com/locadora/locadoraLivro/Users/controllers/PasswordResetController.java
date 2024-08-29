package com.locadora.locadoraLivro.Users.controllers;

import com.locadora.locadoraLivro.Users.DTOs.EmailRequestDTO;
import com.locadora.locadoraLivro.Users.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PasswordResetController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/forgot")
    public ResponseEntity<String> processForgotPassword(@RequestBody EmailRequestDTO emailRequestDTO) {
        String email = emailRequestDTO.email;

        String token = userServices.createPasswordResetToken(email);
        if (token == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        String resetLink = "http://localhost:8040/api/password/reset-password?token=" + token;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password reset");
        message.setText("Click the link to reset your password: " + resetLink);

        mailSender.send(message);

        return ResponseEntity.ok("Success Password reset instructions sent to " + email);
    }

    @GetMapping("/reset-password")
    public ResponseEntity<String> validateResetToken(@RequestParam("token") String token) {
        boolean isValid = userServices.validatePasswordResetToken(token);
        if (!isValid) {
            return ResponseEntity.badRequest().body("Invalid or expired token.");
        }
        return ResponseEntity.ok("Valid token.");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam("token") String token, @RequestParam("newPassword") String newPassword) {
        boolean result = userServices.resetPassword(token, newPassword);
        if (result) {
            return ResponseEntity.ok("Password reset successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to reset password. Invalid or expired token.");
        }
    }
}
