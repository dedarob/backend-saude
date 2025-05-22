package com.example.clinica.vidasaude.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtendimentosDTO{
    private String nomePaciente;
    private String nomeFuncionario;
    private String data;
    private String descricao;
}
