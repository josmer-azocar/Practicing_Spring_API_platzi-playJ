package com.platzi.playJ.persistence.mapper;

import com.platzi.playJ.domain.Genre;
import org.mapstruct.Named;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class StateMapper {

    @Named("stringToBool")
    public static Boolean stringToBool(String state) {
        if (state == null) return null;

        return switch (state.toUpperCase()){
            case "D" -> TRUE;
            case "N" -> FALSE;
            default -> null;
        };
    }

    @Named("boolToString")
    public static String boolToString(Boolean state){
        if (state == null) return null;

        if (state) {
            return "D";
        } else {
            return "N";
        }
    }
}

