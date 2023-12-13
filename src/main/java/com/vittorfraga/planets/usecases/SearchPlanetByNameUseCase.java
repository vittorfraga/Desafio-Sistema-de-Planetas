package com.vittorfraga.planets.usecases;

import com.vittorfraga.planets.dtos.DtoMapper;
import com.vittorfraga.planets.dtos.PlanetResponse;
import com.vittorfraga.planets.entities.Planeta;
import com.vittorfraga.planets.repositories.PlanetaRepository;
import com.vittorfraga.planets.usecases.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class SearchPlanetByNameUseCase {

    @Autowired
    private PlanetaRepository planetaRepository;

    public PlanetResponse execute(String nome) {
        Planeta planeta = planetaRepository.findByNomeIgnoreCase(nome).orElseThrow(() -> new ResourceNotFoundException("Planeta não encontrado com o nome: " + nome));
        return DtoMapper.toResponse(planeta);
    }
}
