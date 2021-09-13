package com.wdt.bookstore.service.converter;

import com.wdt.bookstore.controller.model.BookResponse;
import com.wdt.bookstore.entity.BookEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BookConverter implements Function<BookEntity, BookResponse> {
    @Override
    public BookResponse apply(BookEntity bookEntity) {
        return BookResponse.builder()
                .name(bookEntity.getName())
                .authorName(bookEntity.getAuthor().getName())
                .description(bookEntity.getDescription())
                .rating(bookEntity.getRating())
                .build();
    }
}
