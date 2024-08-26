package com.locadora.locadoraLivro.Renters.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record UpdateRenterRequestDTO(
        @NotBlank(message = "The name cannot be empty or contain only spaces.")
        String name,

        @Email(message = "Email must be valid.")
        @NotBlank(message = "Email cannot be empty or contain only spaces.")
        String email,

        @NotBlank(message = "Telephone cannot be empty")
        String telephone,

        @NotBlank(message = "Address cannot be empty")
        String address

//        @CPF
//        @NotBlank(message = "cpf cannot be null")
//        String cpf;
) {}

