package org.problems.graphql.simpledemo.service;

import org.problems.graphql.simpledemo.entity.BookEntity;
import org.problems.graphql.simpledemo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> getAllBooks(){
        return bookRepository.findAll();
    }

    public BookEntity saveBook(String name, Integer cost, String author){
        return bookRepository.save(new BookEntity(name, cost, author));
    }
}
