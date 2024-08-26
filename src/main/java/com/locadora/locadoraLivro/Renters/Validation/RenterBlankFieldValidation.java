package com.locadora.locadoraLivro.Renters.Validation;

import com.locadora.locadoraLivro.Exceptions.CustomValidationException;
import com.locadora.locadoraLivro.Renters.DTOs.CreateRenterRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class RenterBlankFieldValidation {

    public void validateFields(CreateRenterRequestDTO data) {
        if (isNullOrBlank(data.name())) {
            throw new CustomValidationException("The name cannot be empty or contain only spaces.");
        }
    }

    private boolean isNullOrBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
