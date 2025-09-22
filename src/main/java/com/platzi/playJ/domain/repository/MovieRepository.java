package com.platzi.playJ.domain.repository;

import com.platzi.playJ.domain.dto.MovieDto;
import com.platzi.playJ.domain.dto.UpdateMovieDto;

import java.util.List;

public interface MovieRepository {

    List<MovieDto> getAll();
    MovieDto getById(long id);
    MovieDto save(MovieDto movieDto);
    MovieDto update(long id, UpdateMovieDto updateMovieDto);
    MovieDto delete(long id);
}
