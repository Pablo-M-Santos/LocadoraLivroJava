
package com.locadora.locadoraLivro.Publisher.repositories;

import com.locadora.locadoraLivro.Publisher.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository  extends JpaRepository<PublisherModel, Integer> {
}
