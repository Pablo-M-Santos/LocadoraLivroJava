package com.locadora.locadoraLivro.Book.controllers;

import com.locadora.locadoraLivro.Book.DTOs.CreateBookRequestDTO;
import com.locadora.locadoraLivro.Book.DTOs.BookResponseDTO;
import com.locadora.locadoraLivro.Book.mappers.BookMapper;
import com.locadora.locadoraLivro.Book.services.BookServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookServices bookServices;

    @PostMapping("/book")
    public ResponseEntity<Void> create(@RequestBody @Valid CreateBookRequestDTO data) {
        return bookServices.create(data);
    }

    @GetMapping("/book")
    public ResponseEntity<List<BookResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(bookMapper.toBookResponseList(bookServices.findAll()));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookResponseDTO> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(bookMapper.toBookResponse(bookServices.findById(id).orElseThrow(() -> new RuntimeException("Book not found"))));
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") int id, @RequestBody @Valid CreateBookRequestDTO createBookRequestDTO) {
        return bookServices.update(id, createBookRequestDTO);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") int id) {
        return bookServices.delete(id);
    }
}
