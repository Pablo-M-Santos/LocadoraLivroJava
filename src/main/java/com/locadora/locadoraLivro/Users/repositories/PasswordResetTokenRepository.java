package com.locadora.locadoraLivro.Users.repositories;

import com.locadora.locadoraLivro.Users.DTOs.PasswordResetToken;
import com.locadora.locadoraLivro.Users.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);
    PasswordResetToken findByUser(UserModel user);
}
