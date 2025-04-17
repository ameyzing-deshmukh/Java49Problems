package org.problems.microservices.exceptionhandling;

import org.problems.microservices.exceptionhandling.entity.Movie;
import org.problems.microservices.exceptionhandling.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieBookingApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(MovieRepository repository) {
        return args -> {
            repository.save(new Movie(null, "Sholay", "action"));
            repository.save(new Movie(null, "Kaal", "horror"));
            repository.save(new Movie(null, "Run", "thriller"));
            repository.save(new Movie(null, "Inception", "Sci-Fi"));
            repository.save(new Movie(null, "Titanic", "Romance"));
            repository.save(new Movie(null, "John Wick", "Action"));
            repository.save(new Movie(null, "Avengers", "Action"));
            repository.save(new Movie(null, "Interstellar", "Sci-Fi"));
            repository.save(new Movie(null, "Dangal", "Drama"));
        };
    }
}
