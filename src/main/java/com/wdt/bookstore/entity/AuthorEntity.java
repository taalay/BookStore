package com.wdt.bookstore.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AuthorEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;
    @OneToMany
    private List<BookEntity> books;
}
