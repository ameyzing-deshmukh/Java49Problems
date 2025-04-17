package org.problems.microservices.exceptionhandling.service;

import lombok.RequiredArgsConstructor;
import org.problems.microservices.exceptionhandling.dto.PaginatedResponse;
import org.problems.microservices.exceptionhandling.entity.Movie;
import org.problems.microservices.exceptionhandling.exception.BadRequestException;
import org.problems.microservices.exceptionhandling.exception.ResourceNotFoundException;
import org.problems.microservices.exceptionhandling.repository.MovieRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository repository;

    public Movie getMovieById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found by id: " + id));
    }

    public PaginatedResponse<Movie> getAllMovies(int page, int size) {
        if (page < 0 || size <= 0) {
            throw new BadRequestException("Invalid pagination parameters");
        }
        Pageable pageable = PageRequest.of(page, size);

        Page<Movie> moviePage = repository.findAll(pageable);
        return new PaginatedResponse<>(moviePage.getContent(), moviePage.getNumber(), moviePage.getSize(), moviePage.getTotalElements(), moviePage.getTotalPages());
    }
}
