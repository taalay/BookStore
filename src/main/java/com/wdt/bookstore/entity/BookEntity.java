package com.wdt.bookstore.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BookEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private Integer rating;
    @ManyToOne
    @JoinColumn(nullable = false)
    private AuthorEntity author;
}
