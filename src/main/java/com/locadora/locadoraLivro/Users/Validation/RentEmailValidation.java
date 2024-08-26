package com.locadora.locadoraLivro.Users.Validation;

import com.locadora.locadoraLivro.Exceptions.CustomValidationException;
import com.locadora.locadoraLivro.Users.DTOs.CreateUserRequestDTO;
import com.locadora.locadoraLivro.Users.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class RentEmailValidation {

    private final UserRepository userRepository;

    public RentEmailValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateEmail(CreateUserRequestDTO data) {
        if (userRepository.findByEmail(data.email()) != null) {
            throw new CustomValidationException("Email already in use.");
        }
    }
}
