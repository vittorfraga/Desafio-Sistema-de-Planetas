package com.vittorfraga.planets.usecases;

import com.vittorfraga.planets.dtos.DtoMapper;
import com.vittorfraga.planets.dtos.PlanetResponse;
import com.vittorfraga.planets.entities.Planeta;
import com.vittorfraga.planets.repositories.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ListPlanetsUseCase {

    @Autowired
    private PlanetaRepository planetaRepository;


    public Page<PlanetResponse> execute(Pageable pageable) {
        Page<Planeta> planetas = planetaRepository.findAll(pageable);
        return planetas.map(DtoMapper::toResponse);
    }
}
