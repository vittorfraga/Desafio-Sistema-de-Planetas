package com.vittorfraga.planets.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vittorfraga.planets.dtos.PlanetRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional
public class SwapiService {

    public int obterQuantidadeAparicoesEmFilmes(PlanetRequest planetRequest) {
        String nomeDoPlaneta = planetRequest.nome();
        String url = "https://swapi.dev/api/planets/?search=" + nomeDoPlaneta;

        RestTemplate restTemplate = new RestTemplate();
        SwapiPlanetResponse swapiPlanetResponse = restTemplate.getForObject(url, SwapiPlanetResponse.class);

        if (swapiPlanetResponse == null || swapiPlanetResponse.results() == null || swapiPlanetResponse.results().isEmpty()) {
            return 0;
        }

        SwapiPlanetResult firstResult = swapiPlanetResponse.results().get(0);
        List<String> films = firstResult.films();

        return films.size();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private record SwapiPlanetResult(List<String> films) {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private record SwapiPlanetResponse(List<SwapiPlanetResult> results) {
    }
}
