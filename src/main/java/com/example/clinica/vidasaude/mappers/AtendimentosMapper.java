package com.example.clinica.vidasaude.mappers;

import com.example.clinica.vidasaude.dto.AtendimentosDTO;
import com.example.clinica.vidasaude.dto.AtendimentosRequestDTO;
import com.example.clinica.vidasaude.models.Atendimentos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AtendimentosMapper {

    @Mapping(source = "paciente.pessoa.nome", target = "nomePaciente")
    @Mapping(source = "funcionario.pessoa.nome", target = "nomeFuncionario")
    @Mapping(source = "data", target = "data")
    @Mapping(source = "descricao", target = "descricao")
    AtendimentosDTO toDTO(Atendimentos atendimento);

    List<AtendimentosDTO> toDTO(List<Atendimentos> atendimentos);

    Atendimentos toModel(AtendimentosRequestDTO dto);
}
