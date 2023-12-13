package com.vittorfraga.planets.dtos;

import jakarta.validation.constraints.NotBlank;

public record PlanetRequest(
        @NotBlank(message = "O nome não pode ser em branco") String nome,
        @NotBlank(message = "O clima não pode ser em branco") String clima,
        @NotBlank(message = "O terreno não pode ser em branco") String terreno
) {
    

}
