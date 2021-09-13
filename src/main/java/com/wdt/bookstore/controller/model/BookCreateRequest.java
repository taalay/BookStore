package com.wdt.bookstore.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BookCreateRequest {

    @NotNull
    private String name;
    private String description;
    @NotNull
    private Integer rating;
}
