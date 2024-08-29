package com.locadora.locadoraLivro.Users.repositories;

import com.locadora.locadoraLivro.Users.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    UserModel findByName(String name);
    UserModel findByEmail(String email);

}
