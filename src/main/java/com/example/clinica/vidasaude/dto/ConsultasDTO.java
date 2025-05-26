package com.example.clinica.vidasaude.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConsultasDTO {
    private String data;
    private String nomePaciente;
    private String nomeMedico;
    private String status;

}
