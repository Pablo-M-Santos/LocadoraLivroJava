package com.locadora.locadoraLivro.Rents.DTOs;

import lombok.Builder;
import java.time.LocalDate;

@Builder
public record RentResponseDTO(
        int id,
        int bookId,
        int rentId,
        LocalDate rentalDate,
        LocalDate returnDate
) {
}
