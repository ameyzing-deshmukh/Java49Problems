package org.problems.microservices.hateoas.controller;

import org.problems.microservices.hateoas.model.Book;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BookModelAssembler implements RepresentationModelAssembler<Book, EntityModel<Book>> {

    @Override
    public EntityModel<Book> toModel(Book book) {
        return EntityModel.of(book, linkTo(methodOn(HateoasController.class).getBook(book.getId())).withSelfRel(),
                linkTo(methodOn(HateoasController.class).getAllBooks()).withRel("books"));
    }
}
