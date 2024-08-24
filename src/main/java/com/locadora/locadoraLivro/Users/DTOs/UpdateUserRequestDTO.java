package com.locadora.locadoraLivro.Users.DTOs;

import com.locadora.locadoraLivro.Users.models.UserRoleEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateUserRequestDTO(
        @NotBlank String name,
        @NotBlank String email,
        String password,
        @NotNull UserRoleEnum role) {
}
