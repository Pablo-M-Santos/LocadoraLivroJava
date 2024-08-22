package com.locadora.locadoraLivro.Rent.mappers;

import com.locadora.locadoraLivro.Rent.DTOs.RentResponseDTO;
import com.locadora.locadoraLivro.Rent.models.RentModel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Component
public class RentMapper {

    public List<RentResponseDTO> toRentResponseList(List<RentModel> rentList) {
        return rentList.stream().map(this::toRentResponse).toList();
    }

    public RentResponseDTO toRentResponse(RentModel model) {
        return RentResponseDTO
                .builder()
                .id(model.getId())
                .bookId(model.getBook().getId())
                .rentId(model.getRenter().getId())
                .rentalDate(model.getRentalDate())
                .returnDate(model.getReturnDate())
                .build();
    }
}
