package com.joshaby.springboot2graphql.repository;

import com.joshaby.springboot2graphql.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
