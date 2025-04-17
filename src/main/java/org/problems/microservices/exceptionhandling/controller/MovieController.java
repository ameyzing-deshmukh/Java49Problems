package org.problems.microservices.exceptionhandling.controller;

import lombok.RequiredArgsConstructor;
import org.problems.microservices.exceptionhandling.dto.PaginatedResponse;
import org.problems.microservices.exceptionhandling.entity.Movie;
import org.problems.microservices.exceptionhandling.repository.MovieRepository;
import org.problems.microservices.exceptionhandling.service.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
class MovieController {
    private final MovieRepository repo;

    private final MovieService service;

//    @PostMapping
//    public Movie create(@RequestBody Movie movie) {
//        return repo.save(movie);
//    }

    @GetMapping
    public PaginatedResponse<Movie> all(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
        return service.getAllMovies(page, size);
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return service.getMovieById(id);
    }
}
