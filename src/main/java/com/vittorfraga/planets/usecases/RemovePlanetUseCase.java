package com.vittorfraga.planets.usecases;

import com.vittorfraga.planets.repositories.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RemovePlanetUseCase {


    @Autowired
    private PlanetaRepository planetaRepository;
    private SearchPlanetByIdUseCase searchPlanetByIdUseCase;

    public void execute(Long id) {

        searchPlanetByIdUseCase.execute(id);

        planetaRepository.deleteById(id);
    }
}
