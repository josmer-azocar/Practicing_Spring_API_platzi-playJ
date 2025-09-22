package com.platzi.playJ.domain.service;

import com.platzi.playJ.domain.dto.MovieDto;
import com.platzi.playJ.domain.dto.UpdateMovieDto;
import com.platzi.playJ.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Tool("Busca todas las peliculas existentes en la plataforma")
    public List<MovieDto> getAll() {
        return this.movieRepository.getAll();
    }

    public MovieDto getById(long id){
        return this.movieRepository.getById(id);
    }

    public MovieDto add(MovieDto movieDto){
       return this.movieRepository.save(movieDto);
    }

    public MovieDto update(long id, UpdateMovieDto updateMovieDto){
        return this.movieRepository.update(id, updateMovieDto);
    }

    public MovieDto delete(long id){
       return this.movieRepository.delete(id);
    }
}
