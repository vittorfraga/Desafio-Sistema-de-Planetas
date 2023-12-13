package com.vittorfraga.planets.repositories;

import com.vittorfraga.planets.entities.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanetaRepository extends JpaRepository<Planeta, Long> {
    Optional<Planeta> findByNome(String nome);
}
