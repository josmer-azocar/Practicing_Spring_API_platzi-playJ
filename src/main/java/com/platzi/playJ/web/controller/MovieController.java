package com.platzi.playJ.web.controller;

import com.platzi.playJ.domain.dto.MovieDto;
import com.platzi.playJ.domain.dto.SuggestRequestDto;
import com.platzi.playJ.domain.dto.UpdateMovieDto;
import com.platzi.playJ.domain.service.MovieService;
import com.platzi.playJ.domain.service.PlatziPlayAIService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@Tag(name = "Movies", description = "Movies of PlatziPlayJ")
public class MovieController {

    private final MovieService movieService;
    private final PlatziPlayAIService aiService;

    public MovieController(MovieService movieService, PlatziPlayAIService aiService) {
        this.movieService = movieService;
        this.aiService = aiService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll(){
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get a movie by its id",
            description = "return MovieDto (Record Object)",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Pelicula encontrada"),
                    @ApiResponse(responseCode = "404", description = "Pelicula no encontrada", content = @Content)
            }
    )
    public ResponseEntity<MovieDto> getById(@Parameter(description = "identificador de la pelicula",
                                                       example = "9")
                                            @PathVariable long id)  {

        MovieDto movieDto = this.movieService.getById(id);

        if (movieDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieDto);
    }

    @PostMapping("/suggest")
    public ResponseEntity<String> generateMovieSuggestions(@RequestBody SuggestRequestDto suggestRequestDto){
       return ResponseEntity.ok(this.aiService.generateMovieSuggestion(suggestRequestDto.userPreference()));
    }

    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody @Valid MovieDto movieDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.add(movieDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable long id, @RequestBody @Valid UpdateMovieDto updateMovieDto){
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDto> delete(@PathVariable long id){
        return ResponseEntity.ok(this.movieService.delete(id));
    }
}
