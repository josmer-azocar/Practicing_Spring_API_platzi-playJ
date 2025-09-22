package com.platzi.playJ.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAIService {

    @UserMessage("""
                 Genera un Saludo de bienvenida de la plataforma de Gestion de Peliculas {{platform}} al estilo de Platzi.
                 """)
    String generateGreeting(@V("platform")String platform);

    @SystemMessage("""
            Eres un experto en peliculas, debes recomendarle al usuario un maximo de 3 peliculas segun sus gustos
            solo debes recomendar las que esten dentro de la plataforma Platzi PLayJ.
            """)
    String generateMovieSuggestion(@UserMessage String userMessage);
}
