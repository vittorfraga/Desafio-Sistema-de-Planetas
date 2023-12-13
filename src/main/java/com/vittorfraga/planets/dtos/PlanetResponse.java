package com.vittorfraga.planets.dtos;

public record PlanetResponse(
        Long id,
        String nome,
        String clima,
        String terreno,
        int quantidadeAparicoes
) {
}
