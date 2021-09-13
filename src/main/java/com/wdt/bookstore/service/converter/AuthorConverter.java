package com.wdt.bookstore.service.converter;

import com.wdt.bookstore.controller.model.AuthorResponse;
import com.wdt.bookstore.entity.AuthorEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AuthorConverter implements Function<AuthorEntity, AuthorResponse> {
    @Override
    public AuthorResponse apply(AuthorEntity authorEntity) {
        return AuthorResponse.builder().name(authorEntity.getName()).build();
    }
}
