package Books.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.locadora.locadoraLivro.Publishers.models.PublisherModel;

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
    private int totalQuantity;
    private String launchDate;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherModel publisher;

    public BookModel(String name, String author, String launchDate, int totalQuantity, PublisherModel publisher) {
        this.name = name;
        this.author = author;
        this.totalQuantity = totalQuantity;
        this.launchDate = launchDate;
        this.publisher = publisher;
    }
}
