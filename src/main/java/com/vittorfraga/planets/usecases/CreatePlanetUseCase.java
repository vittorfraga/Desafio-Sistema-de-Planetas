package com.vittorfraga.planets.usecases;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vittorfraga.planets.dtos.DtoMapper;
import com.vittorfraga.planets.dtos.PlanetRequest;
import com.vittorfraga.planets.dtos.PlanetResponse;
import com.vittorfraga.planets.entities.Planeta;
import com.vittorfraga.planets.repositories.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional
public class CreatePlanetUseCase {

    @Autowired
    private PlanetaRepository planetaRepository;

    public PlanetResponse execute(PlanetRequest planetRequest) {
        Planeta planeta = new Planeta();
        DtoMapper.toEntity(planetRequest, planeta);

        int quantidadeAparicoes = obterQuantidadeAparicoesEmFilmes(planetRequest);
        planeta.setQuantidadeAparicoes(quantidadeAparicoes);

        Planeta planetaSalvo = planetaRepository.save(planeta);

        return DtoMapper.toResponse(planetaSalvo);
    }

    private int obterQuantidadeAparicoesEmFilmes(PlanetRequest planetRequest) {
        String nomeDoPlaneta = planetRequest.nome();
        String url = "https://swapi.dev/api/planets/?search=" + nomeDoPlaneta;


        RestTemplate restTemplate = new RestTemplate();
        SwapiPlanetResponse swapiPlanetResponse = restTemplate.getForObject(url, SwapiPlanetResponse.class);

        if (swapiPlanetResponse != null && swapiPlanetResponse.results() != null && !swapiPlanetResponse.results().isEmpty()) {
            SwapiPlanetResult firstResult = swapiPlanetResponse.results().get(0);
            List<String> films = firstResult.films();
            return films != null ? films.size() : 0;
        } else {
            return 0;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record SwapiPlanetResult(List<String> films) {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record SwapiPlanetResponse(List<SwapiPlanetResult> results) {
    }
}
