package com.example.clinica.vidasaude.mappers;

import com.example.clinica.vidasaude.dto.PacienteCompletoDTO;
import com.example.clinica.vidasaude.models.Pacientes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    @Mapping(source = "nomePaciente", target = "pessoa.nome")
    Pacientes toModel(PacienteCompletoDTO dto);
}