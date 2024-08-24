package com.locadora.locadoraLivro.Publishers.DTOs;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Email;

public record CreatePublisherRequestDTO(
        @NotEmpty (message = "Name cannot be empty") String name,
        @Email(message = "Email should be valid") @NotEmpty(message = "Email cannot be empty") String email,
        @NotEmpty(message = "Telephone cannot be empty") String telephone,
        @NotEmpty(message = "Address cannot be empty") String site
) {
}

