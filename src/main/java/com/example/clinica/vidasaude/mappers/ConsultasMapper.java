package com.example.clinica.vidasaude.mappers;

import com.example.clinica.vidasaude.dto.ConsultasDTO;
import com.example.clinica.vidasaude.models.Consultas;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConsultasMapper {
    @Mapping(source = "atendimento.paciente.pessoa.nome", target = "nomePaciente")
    @Mapping(source = "medico.pessoa.nome", target = "nomeMedico")
    ConsultasDTO toDTO(Consultas consultas);

    List<ConsultasDTO> toDTO(List<Consultas> consultas);
}
