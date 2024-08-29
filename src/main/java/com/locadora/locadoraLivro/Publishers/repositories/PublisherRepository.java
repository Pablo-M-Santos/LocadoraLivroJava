
package com.locadora.locadoraLivro.Publishers.repositories;

import com.locadora.locadoraLivro.Publishers.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository  extends JpaRepository<PublisherModel, Integer> {
    UserDetails findByName(String name);
    PublisherModel findByEmail(String email);
    List<PublisherModel> findAllByIsDeletedFalse();

}
