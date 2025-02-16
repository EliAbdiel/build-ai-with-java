package com.springai.service;

import com.springai.dto.Movie;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final ChatClient chatClient;

    @Value("classpath:prompts/movie-template.st")
    private Resource movieResource;

    public MovieService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public ResponseEntity<String> movieInfo(String movieName) {
        try {
            var result = chatClient.prompt()
                    .user(userSpec -> userSpec.text(movieResource)
                            .param("moviename", movieName)
                    )
                    .call()
                    .chatResponse()
                    .getResult()
                    .getOutput()
                    .getContent();

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        }
    }

    public ResponseEntity<?> getDirectorMovieInPojo(String directorName) {
        try {
            var template = """
                    'Generate a list of movies directed by {directorName}. If the director is unknown, return null.
                    Each movie should include a title and release year. {format}'
                    """;

            List<Movie> movieList = chatClient.prompt()
                    .user(userSpec -> userSpec.text(template)
                            .param("directorName", directorName)
                            .param("format", "json")
                    )
                    .call()
                    .entity(new ParameterizedTypeReference<List<Movie>>() {
                    });

            return ResponseEntity.ok(movieList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        }
    }
}
