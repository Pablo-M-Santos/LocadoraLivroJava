package com.locadora.locadoraLivro.Publisher.controllers;

import com.locadora.locadoraLivro.Publisher.DTO.PublisherRecordDto;
import com.locadora.locadoraLivro.Publisher.models.PublisherModel;
import com.locadora.locadoraLivro.Publisher.repositories.PublisherRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {

    @Autowired
    PublisherRepository publisherRepository;

    // POST
    @PostMapping("/publisher")
    public ResponseEntity<PublisherModel> savePublisher(@RequestBody @Valid PublisherRecordDto publisherRecordDTO) {
        var publisherModel = new PublisherModel();
        BeanUtils.copyProperties(publisherRecordDTO, publisherModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(publisherRepository.save(publisherModel));
    }

    // GET
    @GetMapping("/publisher")
    public ResponseEntity<List<PublisherModel>> getAllPublishers() {
        return ResponseEntity.status(HttpStatus.OK).body(publisherRepository.findAll());
    }

    // GET ID
    @GetMapping("/publisher/{id}")
    public ResponseEntity<Object> getOnePublisher(@PathVariable(value = "id") int id) {
        Optional<PublisherModel> publisher0 = publisherRepository.findById(id);
        if (publisher0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publisher not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(publisher0.get());
    }

    // PUT
    @PutMapping("/publisher/{id}")
    public ResponseEntity<Object> updatePublisher(@PathVariable(value = "id") int id, @RequestBody @Valid PublisherRecordDto publisherRecordDto) {
        Optional<PublisherModel> publisher0 = publisherRepository.findById(id);
        if (publisher0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publisher not found.");
        }
        var publisherModel = publisher0.get();
        BeanUtils.copyProperties(publisherRecordDto, publisherModel);
        return ResponseEntity.status(HttpStatus.OK).body(publisherRepository.save(publisherModel));
    }

    // DEL
    @DeleteMapping("/publisher/{id}")
    public ResponseEntity<Object> deletePublisher(@PathVariable(value = "id") int id) {
        Optional<PublisherModel> publisher0 = publisherRepository.findById(id);
        if (publisher0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publisher not found.");
        }
        publisherRepository.delete(publisher0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Publisher deleted sucessfully.");
    }
}
