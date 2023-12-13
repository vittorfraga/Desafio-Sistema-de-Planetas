package com.vittorfraga.planets.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_planeta")
@Data
public class Planeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String clima;
    private String terreno;
    private int quantidadeAparicoes;
}
