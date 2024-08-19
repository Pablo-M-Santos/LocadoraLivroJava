package com.locadora.locadoraLivro.users.repositories;

import com.locadora.locadoraLivro.users.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    UserDetails findByName(String name);
}
