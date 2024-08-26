package com.locadora.locadoraLivro.Renters.Validation;

import com.locadora.locadoraLivro.Exceptions.CustomValidationException;
import com.locadora.locadoraLivro.Renters.DTOs.CreateRenterRequestDTO;
import com.locadora.locadoraLivro.Renters.repositories.RenterRepository;
import org.springframework.stereotype.Component;

@Component
public class RentertEmailValidation {

    private final RenterRepository renterRepository;



    public RentertEmailValidation(RenterRepository renterRepository) {
        this.renterRepository = renterRepository;
    }

    public void validateEmail(CreateRenterRequestDTO data) {
        if (renterRepository.findByEmail(data.email()) != null) {
            throw new CustomValidationException("Email already in use.");
        }
    }
}
