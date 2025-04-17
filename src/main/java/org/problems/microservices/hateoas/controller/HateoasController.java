package org.problems.microservices.hateoas.controller;

import lombok.RequiredArgsConstructor;
import org.problems.microservices.hateoas.model.Book;
import org.problems.microservices.hateoas.repository.BookRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class HateoasController {

    private final BookRepository bookRepository;

    private final BookModelAssembler bookModelAssembler;

    @GetMapping("/{id}")
    public EntityModel<Book> getBook(@PathVariable Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return bookModelAssembler.toModel(book);
    }

    @GetMapping("/")
    public CollectionModel<EntityModel<Book>> getAllBooks() {
        List<EntityModel<Book>> books = bookRepository.findAll().stream().map(bookModelAssembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(books, linkTo(methodOn(HateoasController.class).getAllBooks()).withSelfRel());
    }
}
