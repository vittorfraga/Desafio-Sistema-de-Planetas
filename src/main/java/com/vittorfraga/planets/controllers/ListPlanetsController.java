package com.vittorfraga.planets.controllers;

import com.vittorfraga.planets.dtos.PlanetResponse;
import com.vittorfraga.planets.usecases.ListPlanetsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/planetas")
@Tag(name = "Planetas", description = "Controlador de planetas")
public class ListPlanetsController {

    @Autowired
    private ListPlanetsUseCase listPlanetsUseCase;

    @Operation(
            description = "Listar todos os planetas",
            summary = "Listar todos os planetas",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
            }
    )
    @GetMapping
    public ResponseEntity<Page<PlanetResponse>> listAllPlanets(Pageable pageable) {
        Page<PlanetResponse> planets = listPlanetsUseCase.execute(pageable);
        return ResponseEntity.ok(planets);
    }
}
