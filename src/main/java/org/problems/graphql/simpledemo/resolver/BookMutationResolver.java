package org.problems.graphql.simpledemo.resolver;

import org.problems.graphql.simpledemo.entity.BookEntity;
import org.problems.graphql.simpledemo.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookMutationResolver {

    private final BookService bookService;

    public BookMutationResolver(BookService bookService) {
        this.bookService = bookService;
    }

    @MutationMapping
    public BookEntity saveBook(@Argument String name, @Argument Integer cost, @Argument String author){
        return bookService.saveBook(name, cost, author);
    }
}
