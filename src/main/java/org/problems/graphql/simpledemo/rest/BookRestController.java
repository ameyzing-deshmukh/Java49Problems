package org.problems.graphql.simpledemo.rest;

import org.problems.graphql.simpledemo.dto.BookDto;
import org.problems.graphql.simpledemo.entity.BookEntity;
import org.problems.graphql.simpledemo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRestController {

    private BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/save")
    public ResponseEntity saveBook(@RequestBody BookDto bookDto){
        BookEntity bookEntity = bookService.saveBook(bookDto.getName(), bookDto.getCost(), bookDto.getAuthor());
        return ResponseEntity.ok("Book saved. Book Id: "+bookEntity.getId()+" Book name: "+bookEntity.getName());
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<BookEntity>> getAllBooks(){
        List<BookEntity> bookEntities = bookService.getAllBooks();
        ResponseEntity responseEntity = ResponseEntity.ok(bookEntities);
        return responseEntity;
    }
}
