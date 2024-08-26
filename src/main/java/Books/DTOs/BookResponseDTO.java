package Books.DTOs;

import lombok.Builder;

@Builder
public record BookResponseDTO(
        int id,
        String name,
        String author,
        int publisherId,
        String launchDate,
        int totalQuantity
) {
}
