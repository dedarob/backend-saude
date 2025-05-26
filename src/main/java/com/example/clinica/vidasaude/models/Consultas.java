package com.example.clinica.vidasaude.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="consultas")
public class Consultas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn
    @OneToOne
    private Atendimentos atendimento;

    @JoinColumn
    @OneToOne
    private Medicos medico;

    private String data;
    private String status;
}
