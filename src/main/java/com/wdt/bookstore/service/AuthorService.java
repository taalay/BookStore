package com.wdt.bookstore.service;

import com.wdt.bookstore.entity.AuthorEntity;
import com.wdt.bookstore.exceptions.AuthorException;
import com.wdt.bookstore.exceptions.AuthorNotFoundException;
import com.wdt.bookstore.repository.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorEntity findById(Long id){
        if(Objects.isNull(id)) throw new AuthorException("id cannot be null");
        return authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("could not find author by given id " + id));
    }

    public Page<AuthorEntity> findAll(Pageable pageable){

        return authorRepository.findAll(pageable);
    }

    public AuthorEntity save(AuthorEntity entity){
        return authorRepository.save(entity);
    }

    public void deleteById(Long id){
        if(Objects.isNull(id)) throw new AuthorException("id cannot be null");
        authorRepository.deleteById(id);
    }
}
