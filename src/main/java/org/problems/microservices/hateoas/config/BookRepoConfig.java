package org.problems.microservices.hateoas.config;

import org.problems.microservices.hateoas.model.Book;
import org.problems.microservices.hateoas.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookRepoConfig {

    @Autowired
    BookRepository bookRepository;

    @Bean
    CommandLineRunner init() {
        return args -> {
            bookRepository.save(new Book("The Alchemist", "Paulo Coelho", null));
            bookRepository.save(new Book("1984", "George Orwell", null));
        };
    }
}
