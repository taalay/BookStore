package com.wdt.bookstore.controller.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {

    private String name;
    private String authorName;
    private String description;
    private Integer rating;
}
