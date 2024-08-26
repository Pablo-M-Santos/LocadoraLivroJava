package Books.services;

import Books.DTOs.CreateBookRequestDTO;
import Books.models.BookModel;
import Books.repositories.BookRepository;
import com.locadora.locadoraLivro.Publishers.repositories.PublisherRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    public ResponseEntity<Void> create(@Valid CreateBookRequestDTO data) {
        var publisher = publisherRepository.findById(data.publisherId()).orElseThrow(() -> new RuntimeException("Publisher not found"));
        BookModel newBook = new BookModel(data.name(), data.author(), data.launchDate(), data.totalQuantity(), publisher);
        bookRepository.save(newBook);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public List<BookModel> findAll() {
        return bookRepository.findAll();
    }

    public Optional<BookModel> findById(int id) {
        return bookRepository.findById(id);
    }

    public ResponseEntity<Object> update(int id, @Valid CreateBookRequestDTO createBookRequestDTO) {
        Optional<BookModel> response = bookRepository.findById(id);
        if (response.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
        var bookModel = response.get();
        var publisher = publisherRepository.findById(createBookRequestDTO.publisherId()).orElseThrow(() -> new RuntimeException("Publisher not found"));
        BeanUtils.copyProperties(createBookRequestDTO, bookModel);
        bookModel.setPublisher(publisher);
        return ResponseEntity.status(HttpStatus.OK).body(bookRepository.save(bookModel));
    }

    public ResponseEntity<Object> delete(int id) {
        Optional<BookModel> response = bookRepository.findById(id);
        if (response.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
        bookRepository.delete(response.get());
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully");
    }
}
