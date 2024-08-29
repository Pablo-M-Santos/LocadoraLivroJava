package com.locadora.locadoraLivro.Books.Validation;

import com.locadora.locadoraLivro.Books.DTOs.CreateBookRequestDTO;
import com.locadora.locadoraLivro.Books.DTOs.UpdateBookRecordDTO;
import com.locadora.locadoraLivro.Books.repositories.BookRepository;
import com.locadora.locadoraLivro.Exceptions.CustomValidationException;
import com.locadora.locadoraLivro.Rents.models.RentStatusEnum;
import com.locadora.locadoraLivro.Rents.repositories.RentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@AllArgsConstructor
@Component
public class BookValidation {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    RentRepository rentRepository;

    public void validLaunchDate(CreateBookRequestDTO data){
        if (data.launchDate().isAfter(LocalDate.now())){
            throw new CustomValidationException("Launch Date cannot be in future");
        }
    }

    public void validLaunchDateUpdate(UpdateBookRecordDTO data){
        if (data.launchDate().isAfter(LocalDate.now())){
            throw new CustomValidationException("Launch Date cannot be in future");
        }
    }


    public void validTotalQuantity(CreateBookRequestDTO data){
        if (data.totalQuantity() <= 0){
            throw new CustomValidationException("The total quantity cannot be less than 1");
        }
    }

    public void validTotalQuantityUpdate(UpdateBookRecordDTO data){
        if (data.totalQuantity() <= 0){
            throw new CustomValidationException("The total quantity cannot be less than 1");
        }
    }

    public void validDeleteBook(int id){
        boolean hasActiveRent = rentRepository.existsByBookIdAndStatus(id, RentStatusEnum.RENTED);
        if (hasActiveRent) {
            throw new CustomValidationException("The book cannot be deleted because it has an active rental.");
        }
    }
}