package com.joshaby.springboot2graphql.repository;

import com.joshaby.springboot2graphql.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
