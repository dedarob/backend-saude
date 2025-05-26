package com.example.clinica.vidasaude.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AtendimentosRequestDTO {
    private String data;
    private Integer pacienteId;
    private Integer funcionarioId;
    private String descricao;
}
