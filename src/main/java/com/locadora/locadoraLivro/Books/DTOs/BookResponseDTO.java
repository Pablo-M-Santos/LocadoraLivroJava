package com.locadora.locadoraLivro.Books.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.locadora.locadoraLivro.Publishers.DTOs.PublisherResponseDTO;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record BookResponseDTO(
        int id,
        String name,
        String author,
        @JsonFormat(pattern = "yyyy-MM-dd") LocalDate launchDate,
        int totalQuantity,
        PublisherResponseDTO publisher
) {
}
