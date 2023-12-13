package com.vittorfraga.planets.dtos;

import com.vittorfraga.planets.entities.Planeta;

public class DtoMapper {

    public static PlanetResponse toResponse(Planeta planeta) {
        return new PlanetResponse(
                planeta.getId(),
                planeta.getNome(),
                planeta.getClima(),
                planeta.getTerreno(),
                planeta.getQuantidadeAparicoes()
        );
    }

    public static void toEntity(PlanetRequest dto, Planeta entity) {
        entity.setNome(dto.nome());
        entity.setClima(dto.clima());
        entity.setTerreno(dto.terreno());
    }
}
