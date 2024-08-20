package com.locadora.locadoraLivro.Publisher.controllers;

import com.locadora.locadoraLivro.Publisher.DTOs.CreatePublisherRequestDTO;
import com.locadora.locadoraLivro.Publisher.DTOs.PublisherResponseDTO;
import com.locadora.locadoraLivro.Publisher.mappers.PublisherMapper;
import com.locadora.locadoraLivro.Publisher.services.PublisherServices;
import com.locadora.locadoraLivro.Renters.DTOs.RenterResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublisherController {

    @Autowired
    PublisherMapper publisherMapper;

    @Autowired
    PublisherServices publisherServices;

    @PostMapping("/publisher")
    public ResponseEntity<Void> create(@RequestBody @Valid CreatePublisherRequestDTO data) {
        return publisherServices.create(data);
    }

    @GetMapping("/publisher")
    public ResponseEntity<List<PublisherResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(publisherMapper.toPublisherResponseList(publisherServices.findAll()));
    }

    @GetMapping("/publisher/{id}")
    public ResponseEntity<PublisherResponseDTO> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(publisherMapper.toPublisherResponse(publisherServices.findById(id).orElseThrow(() -> new RuntimeException("Renter not found"))));
    }

    @PutMapping("/publisher/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") int id, @RequestBody @Valid CreatePublisherRequestDTO createPublisherRequestDTO) {
        return publisherServices.update(id, createPublisherRequestDTO);
    }

    @DeleteMapping("/publisher/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") int id) {
        return publisherServices.delete(id);
    }
}
