package com.locadora.locadoraLivro.Users.Validation;

import com.locadora.locadoraLivro.Exceptions.CustomValidationException;
import com.locadora.locadoraLivro.Users.DTOs.CreateUserRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class RentBlankFieldValidation {

    public void validateFields(CreateUserRequestDTO data) {
        if (isNullOrBlank(data.name())) {
            throw new CustomValidationException("The name cannot be empty or contain only spaces.");
        }

        if (isNullOrBlank(data.email())) {
            throw new CustomValidationException("Email cannot be empty or contain only spaces.");
        }

        if (isNullOrBlank(data.password())) {
            throw new CustomValidationException("Password cannot be empty or contain only spaces.");
        }

        if (data.role() == null) {
            throw new CustomValidationException("Access level cannot be null.");
        }
    }

    private boolean isNullOrBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
