package com.locadora.locadoraLivro.Books.repositories;

import com.locadora.locadoraLivro.Books.models.BookModel;
import com.locadora.locadoraLivro.Publishers.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {
    UserDetails findByName(String name);
    List<BookModel> findAllByIsDeletedFalse();
}
