package org.problems.graphql.simple.service;

import org.problems.graphql.simple.entity.BookEntity;
import org.problems.graphql.simple.model.Book;
import org.problems.graphql.simple.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    public Long saveBook(Book book){
        return bookRepo.save(new BookEntity(book.getName(), book.getCost())).getBookId();
    }

    public List<BookEntity> getAllBooks(){
       return bookRepo.findAll();
    }
}
