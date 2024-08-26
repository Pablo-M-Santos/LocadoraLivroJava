package Books.DTOs;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateBookRequestDTO(
        @NotEmpty(message = "Name cannot be empty") String name,
        @NotEmpty(message = "Author cannot be empty") String author,
        @NotNull(message = "Publisher ID cannot be null") Integer publisherId,
        @NotEmpty(message = "Release Date cannot be empty") String launchDate,
        @NotNull(message = "Stock cannot be null") Integer totalQuantity
) {
}
