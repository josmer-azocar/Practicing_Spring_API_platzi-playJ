package com.platzi.playJ.persistence.crud;

import com.platzi.playJ.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieEntity extends CrudRepository<MovieEntity, Long> {

    MovieEntity findFirstByTitulo(String titulo);
    MovieEntity findFirstById(long id);

}
