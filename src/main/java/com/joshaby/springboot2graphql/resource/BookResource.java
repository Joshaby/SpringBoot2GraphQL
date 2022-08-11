package com.joshaby.springboot2graphql.resource;

import com.joshaby.springboot2graphql.entity.Author;
import com.joshaby.springboot2graphql.entity.Book;
import com.joshaby.springboot2graphql.repository.AuthorRepository;
import com.joshaby.springboot2graphql.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
@RequiredArgsConstructor
public class BookResource {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    @QueryMapping
    public Book bookById(@Argument Long id) {
        return bookRepository.findById(id).get();
    }

    @MutationMapping
    public Book createBook(@Argument String name,
                           @Argument Integer pageCount,
                           @Argument Integer authorId) {
        Author author = authorRepository.findById(Long.valueOf(authorId)).get();
        Book book = Book.builder().name(name).pageCount(pageCount).author(author).build();
        return bookRepository.save(book);
    }

    @MutationMapping
    public Book createBook1(@Argument Book book) {
        return bookRepository.save(book);
    }
}
