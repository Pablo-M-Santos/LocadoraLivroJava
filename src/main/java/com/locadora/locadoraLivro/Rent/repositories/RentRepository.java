package com.locadora.locadoraLivro.Rent.repositories;

import com.locadora.locadoraLivro.Rent.models.RentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<RentModel, Integer> {
}
