package com.vittorfraga.planets.usecases;

import com.vittorfraga.planets.dtos.DtoMapper;
import com.vittorfraga.planets.dtos.PlanetRequest;
import com.vittorfraga.planets.dtos.PlanetResponse;
import com.vittorfraga.planets.entities.Planeta;
import com.vittorfraga.planets.repositories.PlanetaRepository;
import com.vittorfraga.planets.services.SwapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreatePlanetUseCase {

    @Autowired
    private PlanetaRepository planetaRepository;

    @Autowired
    private SwapiService swapiService;

    public PlanetResponse execute(PlanetRequest planetRequest) {
        Planeta planeta = new Planeta();
        DtoMapper.toEntity(planetRequest, planeta);

        int quantidadeAparicoes = swapiService.obterQuantidadeAparicoesEmFilmes(planetRequest);
        planeta.setQuantidadeAparicoes(quantidadeAparicoes);

        Planeta planetaSalvo = planetaRepository.save(planeta);

        return DtoMapper.toResponse(planetaSalvo);
    }
}


