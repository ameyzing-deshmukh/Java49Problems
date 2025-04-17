package org.problems.microservices.hateoas.repository;

import org.problems.microservices.hateoas.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
