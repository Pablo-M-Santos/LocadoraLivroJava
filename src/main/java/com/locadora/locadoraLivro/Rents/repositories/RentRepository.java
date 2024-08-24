package com.locadora.locadoraLivro.Rents.repositories;

import com.locadora.locadoraLivro.Rents.models.RentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<RentModel, Integer> {
}
