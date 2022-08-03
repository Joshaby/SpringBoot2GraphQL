package com.joshaby.springboot2graphql.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer pageCount;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
