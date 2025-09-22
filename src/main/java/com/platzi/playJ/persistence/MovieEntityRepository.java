package com.platzi.playJ.persistence;

import com.platzi.playJ.domain.dto.MovieDto;
import com.platzi.playJ.domain.dto.UpdateMovieDto;
import com.platzi.playJ.domain.exception.MovieAlreadyExistsExc;
import com.platzi.playJ.domain.exception.MovieDoesNotExistsExc;
import com.platzi.playJ.domain.repository.MovieRepository;
import com.platzi.playJ.persistence.crud.CrudMovieEntity;
import com.platzi.playJ.persistence.entity.MovieEntity;
import com.platzi.playJ.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getById(long id) {
        return this.movieMapper.toDto(this.crudMovieEntity.findById(id).orElse(null));
    }

    @Override
    public MovieDto save(MovieDto movieDto) {
        if (this.crudMovieEntity.findFirstByTitulo(movieDto.title()) != null) {
            throw new MovieAlreadyExistsExc(movieDto.title());
        }

        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);
        movieEntity.setEstado("D");

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto update(long id, UpdateMovieDto updateMovieDto) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);

        if (movieEntity == null) return null;

        this.movieMapper.updateEntityFromDto(updateMovieDto, movieEntity);

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto delete(long id) {
        if (this.crudMovieEntity.findFirstById(id) == null){
            throw new MovieDoesNotExistsExc(id);
        }

        MovieDto movieDto = getById(id);

        this.crudMovieEntity.deleteById(id);

        return movieDto;
    }
}
