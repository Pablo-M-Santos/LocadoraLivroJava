package com.locadora.locadoraLivro.Renters.repositories;

import com.locadora.locadoraLivro.Renters.models.RenterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface RenterRepository extends JpaRepository<RenterModel, Integer> {
    UserDetails findByName(String name);
}
