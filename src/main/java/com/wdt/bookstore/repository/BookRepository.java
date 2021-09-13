package com.wdt.bookstore.repository;

import com.wdt.bookstore.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Page<BookEntity> findByAuthorId(Long authorId, Pageable pageable);
}
