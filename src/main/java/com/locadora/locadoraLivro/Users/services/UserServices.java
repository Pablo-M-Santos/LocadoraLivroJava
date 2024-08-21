package com.locadora.locadoraLivro.Users.services;

import com.locadora.locadoraLivro.Exceptions.ModelNotFoundException;
import com.locadora.locadoraLivro.Users.DTOs.CreateUserRequestDTO;
import com.locadora.locadoraLivro.Users.DTOs.models.UserModel;
import com.locadora.locadoraLivro.Users.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<Void> create(@Valid CreateUserRequestDTO data) {
        if (userRepository.findByName(data.name()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        String encodedPassword = passwordEncoder.encode(data.password());

        UserModel newUser = new UserModel(data.name(), data.email(), encodedPassword, data.role());
        userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public List<UserModel> findAll() {
        List<UserModel> users = userRepository.findAll();
        if (users.isEmpty()) throw new ModelNotFoundException();
        return users;
    }

    public Optional<UserModel> findById(int id) {
        return userRepository.findById(id);
    }

    public ResponseEntity<Object> update(int id, @Valid CreateUserRequestDTO createUserRequestDTO){
        Optional<UserModel> response = userRepository.findById(id);
        if(response.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        var userModel = response.get();

        if (createUserRequestDTO.password() != null) {
            userModel.setPassword(passwordEncoder.encode(createUserRequestDTO.password()));
        }

        BeanUtils.copyProperties(createUserRequestDTO, userModel, "password");
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(userModel));
    }

    public ResponseEntity<Object> delete(int id){
        Optional<UserModel> response = userRepository.findById(id);
        if(response.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        userRepository.delete(response.get());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }
}