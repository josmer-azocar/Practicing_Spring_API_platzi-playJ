package com.platzi.playJ.domain.dto;

import com.platzi.playJ.domain.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record MovieDto(
        Long id,

        @NotBlank
        String title,

        @NotNull
        Integer duration,

        @NotNull
        Genre genre,

        LocalDate releaseDate,
        Double rating,
        String state
) {


}
