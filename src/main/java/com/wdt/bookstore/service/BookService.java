package com.wdt.bookstore.service;

import com.wdt.bookstore.entity.BookEntity;
import com.wdt.bookstore.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookEntity save(BookEntity entity){
        return bookRepository.save(entity);
    }

    public Page<BookEntity> findAll(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    public Page<BookEntity> findBooksByAuthorIdPageable(Long authorId, Pageable pageable) {
        return bookRepository.findByAuthorId(authorId, pageable);
    }
}
