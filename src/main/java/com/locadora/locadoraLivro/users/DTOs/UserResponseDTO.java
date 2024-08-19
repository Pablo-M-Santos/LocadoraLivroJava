package com.locadora.locadoraLivro.users.DTOs;

import com.locadora.locadoraLivro.users.models.UserRoleEnum;
import lombok.Builder;

@Builder
public record UserResponseDTO(
        int id,
        String name,
        String email,
        UserRoleEnum role) {
}