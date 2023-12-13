package com.vittorfraga.planets.controllers;

import com.vittorfraga.planets.dtos.PlanetRequest;
import com.vittorfraga.planets.dtos.PlanetResponse;
import com.vittorfraga.planets.usecases.CreatePlanetUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/planetas")
@Tag(name = "Planetas", description = "Controlador de planetas")
public class CreatePlanetController {

    @Autowired
    private CreatePlanetUseCase createPlanetUseCase;

    @Operation(
            description = "Criar um novo planeta",
            summary = "Criar um novo planeta",
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201"),
                    @ApiResponse(description = "Bad Request", responseCode = "400"),
            }
    )
    @PostMapping(produces = "application/json")
    public ResponseEntity<PlanetResponse> handle(@Valid @RequestBody PlanetRequest planetRequest) {
        PlanetResponse planetResponse = createPlanetUseCase.execute(planetRequest);

        return new ResponseEntity<>(planetResponse, HttpStatus.CREATED);
    }
}
