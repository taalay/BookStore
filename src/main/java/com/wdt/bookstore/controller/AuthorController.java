package com.wdt.bookstore.controller;

import com.wdt.bookstore.controller.model.AuthorCreateRequest;
import com.wdt.bookstore.controller.model.AuthorResponse;
import com.wdt.bookstore.controller.model.BookCreateRequest;
import com.wdt.bookstore.controller.model.BookResponse;
import com.wdt.bookstore.service.BookStoreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final BookStoreService bookStoreService;

    public AuthorController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @GetMapping
    public Page<AuthorResponse> findAll(int page, @RequestParam(defaultValue = "20") int size){
        return bookStoreService.findAuthorsPageable(PageRequest.of(page, size));
    }

    @PostMapping
    public AuthorResponse create(@RequestBody @Valid AuthorCreateRequest authorCreateRequest){
        return bookStoreService.createAuthor(authorCreateRequest);
    }

    @GetMapping("/{authorId}/books")
    public Page<BookResponse> findBooksByAuthorId(@PathVariable("authorId") Long authorId, int page, @RequestParam(defaultValue = "20") int size){
        return bookStoreService.findBooksByAuthorIdPageable(authorId, PageRequest.of(page, size));
    }

    @PostMapping("/{authorId}/books")
    public BookResponse addBookByAuthorId(@PathVariable("authorId") Long authorId, @RequestBody BookCreateRequest bookCreateRequest){
        return bookStoreService.addBookByAuthorId(authorId, bookCreateRequest);
    }
}
