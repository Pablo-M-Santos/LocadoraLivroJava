package com.locadora.locadoraLivro.Users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendRecoveryEmail(String to, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Recuperação de Senha");
        message.setText("Clique no seguinte link para redefinir sua senha: http://localhost:8040/reset-password?token=" + token);
        emailSender.send(message);
    }
}
