package org.problems.microservices.exceptionhandling.repository;

import org.problems.microservices.exceptionhandling.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
