package com.vittorfraga.planets.controllers;

import com.vittorfraga.planets.dtos.PlanetResponse;
import com.vittorfraga.planets.usecases.SearchPlanetByIdUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/planetas")
@Tag(name = "Planetas", description = "Controlador de planetas")
public class SearchPlanetByIdController {

    @Autowired
    private SearchPlanetByIdUseCase searchPlanetByIdUseCase;

    @Operation(
            description = "Buscar um planeta pelo ID",
            summary = "Buscar um planeta pelo ID",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "Id não encontrado", responseCode = "404"),
            }
    )
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanetResponse> handle(@PathVariable Long id) {
        PlanetResponse planet = searchPlanetByIdUseCase.execute(id);
        return ResponseEntity.ok(planet);
    }
}
