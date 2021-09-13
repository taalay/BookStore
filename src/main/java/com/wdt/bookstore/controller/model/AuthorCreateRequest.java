package com.wdt.bookstore.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AuthorCreateRequest {

    @NotNull
    private String name;
}
