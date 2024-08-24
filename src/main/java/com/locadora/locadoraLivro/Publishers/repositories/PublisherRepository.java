
package com.locadora.locadoraLivro.Publishers.repositories;

import com.locadora.locadoraLivro.Publishers.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository  extends JpaRepository<PublisherModel, Integer> {
    UserDetails findByName(String name);
}
