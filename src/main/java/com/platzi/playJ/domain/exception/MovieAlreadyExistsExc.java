package com.platzi.playJ.domain.exception;

public class MovieAlreadyExistsExc extends RuntimeException{
    public MovieAlreadyExistsExc(String movieTile) {
        super("La pelicula " + movieTile + "ya existe");
    }
}
