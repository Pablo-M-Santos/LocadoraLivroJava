package com.locadora.locadoraLivro.Users.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailRequestDTO {

    @NotBlank(message = "The email cannot be empty.")
    @Email(message = "The email format is invalid.")
    public String email;
}
