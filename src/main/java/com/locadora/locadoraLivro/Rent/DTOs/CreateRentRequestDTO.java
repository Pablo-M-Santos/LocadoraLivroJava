package com.locadora.locadoraLivro.Rent.DTOs;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record CreateRentRequestDTO(
        @NotNull(message = "Book ID cannot be null") Integer bookId,
        @NotNull(message = "Renter ID cannot be null") Integer renterId,
        @NotNull(message = "Rental Date cannot be null") LocalDate rentalDate,
        @NotNull(message = "Return Date cannot be null") LocalDate returnDate
) {
}
