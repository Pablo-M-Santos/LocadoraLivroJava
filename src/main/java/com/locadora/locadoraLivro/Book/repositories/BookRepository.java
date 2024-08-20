package com.locadora.locadoraLivro.Book.repositories;

import com.locadora.locadoraLivro.Book.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {
    UserDetails findByName(String name);
}
