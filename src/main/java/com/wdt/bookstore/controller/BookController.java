package com.wdt.bookstore.controller;

import com.wdt.bookstore.controller.model.BookResponse;
import com.wdt.bookstore.service.BookStoreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookStoreService bookStoreService;

    public BookController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @GetMapping
    public Page<BookResponse> findAll(int page, @RequestParam(defaultValue = "20") int size){
        return bookStoreService.findBooksPageable(PageRequest.of(page, size));
    }

    @GetMapping("/rating")
    public Page<BookResponse> findAllByRating(int page, @RequestParam(defaultValue = "20") int size){
        return bookStoreService.findBooksPageable(PageRequest.of(page, size, Sort.by("rating").descending()));
    }
}
