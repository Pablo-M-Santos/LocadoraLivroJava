package com.locadora.locadoraLivro.Book.mappers;

import com.locadora.locadoraLivro.Book.DTOs.BookResponseDTO;
import com.locadora.locadoraLivro.Book.models.BookModel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Component
public class BookMapper {

    public List<BookResponseDTO> toBookResponseList(List<BookModel> bookList) {
        return bookList.stream().map(this::toBookResponse).toList();
    }

    public BookResponseDTO toBookResponse(BookModel model) {
        return BookResponseDTO
                .builder()
                .id(model.getId())
                .name(model.getName())
                .author(model.getAuthor())
                .publisherId(model.getPublisher().getId())
                .launchDate(model.getLaunchDate())
                .totalQuantity(model.getTotalQuantity())
                .build();
    }
}
