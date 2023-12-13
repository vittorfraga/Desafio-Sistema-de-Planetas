package com.vittorfraga.planets.controllers;

import com.vittorfraga.planets.usecases.RemovePlanetUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/planetas")
@Tag(name = "Planetas", description = "Controlador de planetas")
public class DeletePlanetController {

    @Autowired
    private RemovePlanetUseCase removePlanetUseCase;

    @Operation(
            description = "Remover um planeta",
            summary = "Remover um planeta",
            responses = {
                    @ApiResponse(description = "Conteúdo vazio", responseCode = "204"),
                    @ApiResponse(description = "Id não encontrado", responseCode = "404"),
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> handle(@PathVariable Long id) {
        removePlanetUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
