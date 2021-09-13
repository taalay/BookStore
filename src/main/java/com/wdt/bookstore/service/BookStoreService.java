package com.wdt.bookstore.service;

import com.wdt.bookstore.controller.model.AuthorCreateRequest;
import com.wdt.bookstore.controller.model.AuthorResponse;
import com.wdt.bookstore.controller.model.BookCreateRequest;
import com.wdt.bookstore.controller.model.BookResponse;
import com.wdt.bookstore.entity.AuthorEntity;
import com.wdt.bookstore.entity.BookEntity;
import com.wdt.bookstore.service.converter.AuthorConverter;
import com.wdt.bookstore.service.converter.BookConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookStoreService {

    private final AuthorService authorService;
    private final BookService bookService;
    private final AuthorConverter converter;
    private final BookConverter bookConverter;

    public BookStoreService(AuthorService authorService, BookService bookService, AuthorConverter converter, BookConverter bookConverter) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.converter = converter;
        this.bookConverter = bookConverter;
    }

    public Page<AuthorResponse> findAuthorsPageable(PageRequest pageRequest) {
        return authorService.findAll(pageRequest).map(converter);
    }

    public AuthorResponse createAuthor(AuthorCreateRequest authorCreateRequest) {
        AuthorEntity authorEntity = AuthorEntity.builder().name(authorCreateRequest.getName()).build();
        authorEntity = authorService.save(authorEntity);
        return converter.apply(authorEntity);
    }

    public Page<BookResponse> findBooksByAuthorIdPageable(Long authorId, Pageable pageable) {
        return bookService.findBooksByAuthorIdPageable(authorId, pageable).map(bookConverter);
    }

    public BookResponse addBookByAuthorId(Long authorId, BookCreateRequest bookCreateRequest) {
        AuthorEntity authorEntity = authorService.findById(authorId);

        BookEntity bookEntity = BookEntity.builder()
                .name(bookCreateRequest.getName())
                .description(bookCreateRequest.getDescription())
                .rating(bookCreateRequest.getRating())
                .author(authorEntity)
                .build();
        bookEntity = bookService.save(bookEntity);
        return bookConverter.apply(bookEntity);
    }

    public Page<BookResponse> findBooksPageable(PageRequest pageRequest) {
        return bookService.findAll(pageRequest).map(bookConverter);
    }
}
