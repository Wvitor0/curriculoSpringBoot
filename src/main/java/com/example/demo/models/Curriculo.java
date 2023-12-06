package com.example.AtvCurriculo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
@Entity(name = "curriculo")
@Table(name = "curriculo")
public class Curriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String objetivo;
    private String formacao;
    private String xp;
    private String habilidades;
}
