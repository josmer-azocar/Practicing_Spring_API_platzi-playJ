package com.platzi.playJ.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record UpdateMovieDto(
        @NotBlank(message = "el titulo es obligatorio")
        String title,

        @PastOrPresent(message = "la fecha de la lanzamiento no puede ser futura")
        LocalDate releaseDate,

        @Min(value = 0, message = "no puede ser menor que 0")
        @Max(value = 5, message = "no puede ser mayor a 5")
        Double rating
) {
}
