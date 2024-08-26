package com.locadora.locadoraLivro.Users.Validation;

import com.locadora.locadoraLivro.Exceptions.CustomValidationException;
import com.locadora.locadoraLivro.Users.DTOs.CreateUserRequestDTO;
import com.locadora.locadoraLivro.Users.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserValidation {
    private final UserRepository userRepository;

    public void validateEmail(CreateUserRequestDTO data) {
        if (userRepository.findByEmail(data.email()) != null) {
            throw new CustomValidationException("Email already in use.");
        }
    }
}
