package org.problems.graphql.simple.resolver;

import org.problems.graphql.simple.entity.BookEntity;
import org.problems.graphql.simple.service.BookService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookResolver {

    private final BookService bookService;

    public BookResolver(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public List<BookEntity> books(){
        return bookService.getAllBooks();
    }
}
