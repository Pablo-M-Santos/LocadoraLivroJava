package com.locadora.locadoraLivro.Rents.repositories;

import com.locadora.locadoraLivro.Rents.models.RentModel;
import com.locadora.locadoraLivro.Rents.models.RentStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<RentModel, Integer> {
    boolean existsByBookIdAndStatus(int bookId, RentStatusEnum status);
    boolean existsByRenterIdAndStatus(int renterId, RentStatusEnum status);
}
