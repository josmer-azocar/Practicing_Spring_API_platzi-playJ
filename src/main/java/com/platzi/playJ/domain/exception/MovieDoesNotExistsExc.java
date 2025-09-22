package com.platzi.playJ.domain.exception;

public class MovieDoesNotExistsExc extends RuntimeException{
    public MovieDoesNotExistsExc(long id) {
        super("La pelicula con el id " + id + " no existe");
    }
}
