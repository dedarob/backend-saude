package com.example.clinica.vidasaude.services;

import com.example.clinica.vidasaude.dto.AtendimentosDTO;
import com.example.clinica.vidasaude.dto.AtendimentosRequestDTO;
import com.example.clinica.vidasaude.mappers.AtendimentosMapper;
import com.example.clinica.vidasaude.models.Atendimentos;
import com.example.clinica.vidasaude.models.Funcionarios;
import com.example.clinica.vidasaude.models.Pacientes;
import com.example.clinica.vidasaude.respositories.AtendimentosRepository;
import com.example.clinica.vidasaude.respositories.FuncionariosRepository;
import com.example.clinica.vidasaude.respositories.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoServices{
    @Autowired
    private AtendimentosRepository atendimentosRepository;
    @Autowired
    private AtendimentosMapper atendimentosMapper;
    @Autowired
    private PacientesRepository pacientesRepository;
    @Autowired
    FuncionariosRepository funcionariosRepository;

    public List<AtendimentosDTO> getAllAtendimentos(){
       List<Atendimentos> atendimentos = (List<Atendimentos>) atendimentosRepository.findAll();
       return atendimentosMapper.toDTO(atendimentos);
    }

    public Atendimentos registrarAtendimento(AtendimentosRequestDTO dto) {
        Atendimentos atendimento = new Atendimentos();

        atendimento.setData(dto.getData());
        atendimento.setDescricao(dto.getDescricao());

        Pacientes paciente = pacientesRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        Funcionarios funcionario = funcionariosRepository.findById(dto.getFuncionarioId())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        atendimento.setPaciente(paciente);
        atendimento.setFuncionario(funcionario);

        return atendimentosRepository.save(atendimento);
    }
}
