package com.locadora.locadoraLivro.Rent.services;

import com.locadora.locadoraLivro.Rent.DTOs.CreateRentRequestDTO;
import com.locadora.locadoraLivro.Rent.models.RentModel;
import com.locadora.locadoraLivro.Rent.repositories.RentRepository;
import com.locadora.locadoraLivro.Book.repositories.BookRepository;
import com.locadora.locadoraLivro.Customer.repositories.CustomerRepository;
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
    private RentRepository rentRepository;

    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<Void> create(@Valid CreateRentRequestDTO data) {
        var book = bookRepository.findById(data.bookId()).orElseThrow(() -> new RuntimeException("Book not found"));
        var renter = rentRepository.findById(data.renterId()).orElseThrow(() -> new RuntimeException("Customer not found"));

        if (data.returnDate().isAfter(data.rentalDate().plusDays(30))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Return date cannot exceed 30 days from rental date");
        }

        RentModel newRent = new RentModel(book, renter, data.rentalDate(), data.returnDate());
        rentRepository.save(newRent);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public List<RentModel> findAll() {
        return rentRepository.findAll();
    }

    public Optional<RentModel> findById(int id) {
        return rentRepository.findById(id);
    }

    public ResponseEntity<Object> update(int id, @Valid CreateRentRequestDTO createRentRequestDTO) {
        Optional<RentModel> response = rentRepository.findById(id);
        if (response.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rent not found");
        }
        var rentModel = response.get();
        var book = bookRepository.findById(createRentRequestDTO.bookId()).orElseThrow(() -> new RuntimeException("Book not found"));
        var customer = customerRepository.findById(createRentRequestDTO.customerId()).orElseThrow(() -> new RuntimeException("Customer not found"));

        if (createRentRequestDTO.returnDate().isAfter(createRentRequestDTO.rentalDate().plusDays(30))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Return date cannot exceed 30 days from rental date");
        }

        BeanUtils.copyProperties(createRentRequestDTO, rentModel);
        rentModel.setBook(book);
        rentModel.setCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).body(rentRepository.save(rentModel));
    }

    public ResponseEntity<Object> delete(int id) {
        Optional<RentModel> response = rentRepository.findById(id);
        if (response.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rent not found");
        }
        rentRepository.delete(response.get());
        return ResponseEntity.status(HttpStatus.OK).body("Rent deleted successfully");
    }
}
