package com.locadora.locadoraLivro.Books.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.locadora.locadoraLivro.Publishers.models.PublisherModel;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_books")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private LocalDate launchDate;
    private int totalQuantity;
    private Integer availableQuantity;
    private int totalInUse;
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherModel publisher;

    public BookModel(String name, String author, LocalDate launchDate, int totalQuantity, PublisherModel publisher) {
        this.name = name;
        this.author = author;
        this.launchDate = launchDate;
        this.totalQuantity = totalQuantity;
        this.publisher = publisher;
        this.totalInUse = 0;
        this.isDeleted = false;
    }
}
