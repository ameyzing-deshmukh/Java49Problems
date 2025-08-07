package org.problems.graphql.simple.resolver;

import org.problems.graphql.simple.entity.BookEntity;
import org.problems.graphql.simple.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookMutation {

    private BookService bookService;

    public BookMutation(BookService bookService) {
        this.bookService = bookService;
    }

    @MutationMapping
public BookEntity addABook(@Argument String name, @Argument Integer cost){
    return bookService.addBook(name, cost);
}
}
