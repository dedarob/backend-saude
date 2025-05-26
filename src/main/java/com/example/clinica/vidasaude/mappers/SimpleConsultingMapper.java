package com.example.clinica.vidasaude.mappers;

import com.example.clinica.vidasaude.dto.FuncionarioSimplesDTO;
import com.example.clinica.vidasaude.dto.PacienteSimplesDTO;
import com.example.clinica.vidasaude.models.Funcionarios;
import com.example.clinica.vidasaude.models.Pacientes;
import com.example.clinica.vidasaude.models.Pessoas;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SimpleConsultingMapper {
    @Mapping(source = "pessoa.nome", target = "nomeFuncionario")
    FuncionarioSimplesDTO toFuncionarioDTO(Funcionarios funcionario);
    List<FuncionarioSimplesDTO> toFuncionarioDTO (List<Funcionarios> funcionarios);

    @Mapping(source = "pessoa.nome", target = "nomePaciente")
    PacienteSimplesDTO toPacienteDTO(Pacientes paciente);
    List<PacienteSimplesDTO> toPacienteDTO (List<Pacientes> pacientes);
}
