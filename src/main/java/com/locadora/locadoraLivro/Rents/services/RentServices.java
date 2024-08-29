package com.locadora.locadoraLivro.Rents.services;

import com.locadora.locadoraLivro.Books.models.BookModel;
import com.locadora.locadoraLivro.Exceptions.ModelNotFoundException;
import com.locadora.locadoraLivro.Renters.models.RenterModel;
import com.locadora.locadoraLivro.Rents.DTOs.CreateRentRequestDTO;
import com.locadora.locadoraLivro.Rents.Validation.RentValidation;
import com.locadora.locadoraLivro.Rents.models.RentModel;
import com.locadora.locadoraLivro.Rents.models.RentStatusEnum;
import com.locadora.locadoraLivro.Rents.repositories.RentRepository;
import com.locadora.locadoraLivro.Books.repositories.BookRepository;
import com.locadora.locadoraLivro.Renters.repositories.RenterRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RentServices {

    @Autowired
    RentRepository rentRepository;

    @Autowired
    RenterRepository renterRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    RentValidation rentValidation;

    public ResponseEntity<Void> create(@Valid CreateRentRequestDTO data){
        rentValidation.validateRentId(data);

        RenterModel renter = renterRepository.findById(data.renterId())
                .orElseThrow(() -> new IllegalArgumentException("Renter not found"));

        rentValidation.validateBookId(data);

        BookModel book = bookRepository.findById(data.bookId())
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        rentValidation.validateDeadLine(data);

        RentModel newRent = new RentModel(renter, book, data.deadLine());
        rentRepository.save(newRent);

        rentValidation.validateBookTotalQuantity(book);

        book.setTotalQuantity(book.getTotalQuantity() - 1);
        bookRepository.save(book);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public List<RentModel> findAll(){
        List<RentModel> rents = rentRepository.findAll();
        if (rents.isEmpty()) throw new ModelNotFoundException();
        return rents;
    }

    public Optional<RentModel> findById(int id){
        return rentRepository.findById(id);
    }

    public ResponseEntity<Object> update(int id) {
        Optional<RentModel> optionalRent = rentRepository.findById(id);
        if (optionalRent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rent not found");
        }

        RentModel rent = optionalRent.get();

        rent.setDevolutionDate(LocalDate.now());

        if (rent.getDevolutionDate() != null) {
            if (rent.getDevolutionDate().isAfter(rent.getDeadLine())) {
                rent.setStatus(RentStatusEnum.DELIVERED_WITH_DELAY);
            } else {
                rent.setStatus(RentStatusEnum.DELIVERED);
            }
        }

        rentRepository.save(rent);
        return ResponseEntity.status(HttpStatus.OK).body(rent);
    }
}