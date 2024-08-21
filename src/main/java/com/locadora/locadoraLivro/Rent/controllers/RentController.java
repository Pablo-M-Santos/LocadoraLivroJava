package com.locadora.locadoraLivro.Rent.controllers;

import com.locadora.locadoraLivro.Rent.DTOs.CreateRentRequestDTO;
import com.locadora.locadoraLivro.Rent.DTOs.RentResponseDTO;
import com.locadora.locadoraLivro.Rent.mappers.RentMapper;
import com.locadora.locadoraLivro.Rent.services.RentServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentController {

    @Autowired
    private RentMapper rentMapper;

    @Autowired
    private RentServices rentServices;

    @PostMapping("/rent")
    public ResponseEntity<Void> create(@RequestBody @Valid CreateRentRequestDTO data) {
        return rentServices.create(data);
    }

    @GetMapping("/rent")
    public ResponseEntity<List<RentResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(rentMapper.toRentResponseList(rentServices.findAll()));
    }

    @GetMapping("/rent/{id}")
    public ResponseEntity<RentResponseDTO> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(rentMapper.toRentResponse(rentServices.findById(id).orElseThrow(() -> new RuntimeException("Rent not found"))));
    }

    @PutMapping("/rent/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") int id, @RequestBody @Valid CreateRentRequestDTO createRentRequestDTO) {
        return rentServices.update(id, createRentRequestDTO);
    }

    @DeleteMapping("/rent/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") int id) {
        return rentServices.delete(id);
    }
}
