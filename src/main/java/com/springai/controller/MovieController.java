package com.springai.controller;

import com.springai.dto.Movie;
import com.springai.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movie-info")
    public ResponseEntity<String> movieInfo(@RequestParam String movieName) {
        return movieService.movieInfo(movieName);
    }

    @GetMapping("/director-movie-service")
    public ResponseEntity<?> getDirectorMovieInPojo(@RequestParam String directorName) {
        return movieService.getDirectorMovieInPojo(directorName);
    }
}
