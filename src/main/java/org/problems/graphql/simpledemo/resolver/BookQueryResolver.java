package org.problems.graphql.simpledemo.resolver;

import org.problems.graphql.simpledemo.entity.BookEntity;
import org.problems.graphql.simpledemo.service.BookService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import java.util.List;
import org.springframework.stereotype.Controller;

@Controller
public class BookQueryResolver {

    private final BookService bookService;

    public BookQueryResolver(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public List<BookEntity> getAllBooks(){
        return bookService.getAllBooks();
    }
}
