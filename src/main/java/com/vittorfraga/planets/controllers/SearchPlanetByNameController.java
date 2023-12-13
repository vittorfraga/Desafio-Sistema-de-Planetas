package com.vittorfraga.planets.controllers;

import com.vittorfraga.planets.dtos.PlanetResponse;
import com.vittorfraga.planets.usecases.SearchPlanetByNameUseCase;
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
public class SearchPlanetByNameController {

    @Autowired
    private SearchPlanetByNameUseCase searchPlanetByNameUseCase;

    @Operation(
            description = "Buscar um planeta pelo nome",
            summary = "Buscar um planeta pelo nome",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "Nome não encontrado", responseCode = "404"),
            }
    )
    @GetMapping(value = "/buscarPorNome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanetResponse> handle(@PathVariable String nome) {
        PlanetResponse planet = searchPlanetByNameUseCase.execute(nome);
        return ResponseEntity.ok(planet);
    }
}
