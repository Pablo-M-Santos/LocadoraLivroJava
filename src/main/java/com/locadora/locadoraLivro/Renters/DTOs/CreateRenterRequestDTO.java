package com.locadora.locadoraLivro.Renters.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Email;

public record CreateRenterRequestDTO(
        @NotBlank(message = "Name cannot be empty")
        String name,

        @Email(message = "Email should be valid")
        @NotEmpty(message = "Email cannot be empty")
        String email,

        @NotBlank(message = "Telephone cannot be empty")
        String telephone,

        @NotBlank(message = "Address cannot be empty")
        String address,

        @NotBlank(message = "cpf cannot be null")
        String cpf
) {
}
