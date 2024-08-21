package com.locadora.locadoraLivro.Rent.models;

import com.locadora.locadoraLivro.Renters.models.RenterModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.locadora.locadoraLivro.Book.models.BookModel;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_rents")
public class RentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookModel book;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private RenterModel renter;

    private LocalDate rentalDate;
    private LocalDate returnDate;

    public RentModel(BookModel book, RenterModel renter, LocalDate rentalDate, LocalDate returnDate) {
        this.book = book;
        this.renter = renter;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }
}
