package com.locadora.locadoraLivro.Renters.DTOs;

import com.locadora.locadoraLivro.Renters.Validation.ValidTelephone;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

public record CreateRenterRequestDTO(
        @NotBlank(message = "The name cannot be empty or contain only spaces.")
        String name,

        @Email(message = "Email must be valid.")
        @NotEmpty(message = "Email cannot be empty.")
        String email,

        @ValidTelephone(message = "Telephone must be in the format 'XX X####-####'.")
        String telephone,

        @NotBlank(message = "Address cannot be empty or contain only spaces.")
        String address,

        @CPF(message = "The CPF must be valid.")
        String cpf
) {
}
