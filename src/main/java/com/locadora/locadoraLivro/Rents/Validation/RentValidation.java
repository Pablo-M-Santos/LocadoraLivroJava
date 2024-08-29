package com.locadora.locadoraLivro.Rents.Validation;

import com.locadora.locadoraLivro.Books.models.BookModel;
import com.locadora.locadoraLivro.Books.repositories.BookRepository;
import com.locadora.locadoraLivro.Exceptions.CustomValidationException;
import com.locadora.locadoraLivro.Renters.repositories.RenterRepository;
import com.locadora.locadoraLivro.Rents.DTOs.CreateRentRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@AllArgsConstructor
@Component
public class RentValidation {

    @Autowired
    RenterRepository renterRepository;

    @Autowired
    BookRepository bookRepository;

    public void validateRentId(CreateRentRequestDTO data){
        if (renterRepository.findById(data.renterId()).isEmpty()){
            throw new CustomValidationException("Renter not found");
        }
    }

    public void validateBookId(CreateRentRequestDTO data){
        if (bookRepository.findById(data.bookId()).isEmpty()){
            throw new CustomValidationException("Book not found");
        }
    }

    public void validateDeadLine(CreateRentRequestDTO data){
        if (data.deadLine().isAfter(data.deadLine().plusDays(30))){
            throw new CustomValidationException("Deadline cannot be more 30 days.");
        } else if (data.deadLine().isBefore(LocalDate.now())) {
            throw new CustomValidationException("The deadline cannot be in the past.");
        }
    }

    public void validateBookTotalQuantity(BookModel data){
        if (data.getTotalQuantity() <= 0){
            throw new CustomValidationException("There are no books available");
        }
    }
}
