package com.example.clinica.vidasaude.dto;

import com.example.clinica.vidasaude.models.Atendimentos;
import com.example.clinica.vidasaude.models.Medicos;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrarConsultasDTO {
    private Integer atendimentoId;
    private Integer medicoId;
    private String data;
    private String status;
    private String hora;
}
