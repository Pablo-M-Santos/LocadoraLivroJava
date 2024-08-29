package com.locadora.locadoraLivro.Renters.repositories;

import com.locadora.locadoraLivro.Renters.models.RenterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RenterRepository extends JpaRepository<RenterModel, Integer> {
    RenterModel findByEmail(String email);
    RenterModel findByCpf(String cpf);
    List<RenterModel> findAllByIsDeletedFalse();
}
