package com.vittorfraga.planets.usecases;

import com.vittorfraga.planets.dtos.DtoMapper;
import com.vittorfraga.planets.dtos.PlanetResponse;
import com.vittorfraga.planets.entities.Planeta;
import com.vittorfraga.planets.repositories.PlanetaRepository;
import com.vittorfraga.planets.usecases.exceptions.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SearchPlanetByIdUseCase {

    @Autowired
    private PlanetaRepository planetaRepository;

    @Operation(
            description = "Buscar planeta pelo ID",
            summary = "Buscar planeta pelo ID",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "Id não encontrado", responseCode = "404"),
            }
    )
    public PlanetResponse execute(Long id) {
        Planeta planeta = planetaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Planeta não encontrado com o id: " + id));
        return DtoMapper.toResponse(planeta);
    }
}
