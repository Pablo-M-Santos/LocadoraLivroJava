package com.locadora.locadoraLivro.Rent.DTOs;

import lombok.Builder;
import java.time.LocalDate;

@Builder
public record RentResponseDTO(
        int id,
        int bookId,
        int renterId,
        LocalDate rentalDate,
        LocalDate returnDate
) {
}
