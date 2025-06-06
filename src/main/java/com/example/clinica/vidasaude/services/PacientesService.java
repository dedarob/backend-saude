package com.example.clinica.vidasaude.services;

import com.example.clinica.vidasaude.dto.PacienteCompletoDTO;
import com.example.clinica.vidasaude.mappers.PacienteMapper;
import com.example.clinica.vidasaude.models.Pacientes;
import com.example.clinica.vidasaude.models.Pessoas;
import com.example.clinica.vidasaude.respositories.PacientesRepository;
import com.example.clinica.vidasaude.respositories.PessoasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacientesService {

    @Autowired
    PacientesRepository pacRepo;
    @Autowired
    PacienteMapper map;
    @Autowired
    private PessoasRepository pesRepo;
    public Pacientes cadastrarPaciente(PacienteCompletoDTO dto){
        Pessoas pessoa = new Pessoas();
        pessoa.setNome(dto.getNomePaciente());
        Pacientes paciente = new Pacientes();
        paciente.setCondicao(dto.getCondicao());
        pesRepo.save(pessoa);
        paciente.setPessoa(pessoa);
        //Pessoas pessoaSalva = pessoasRepo.save(paciente.getPessoa());
        //Pacientes paciente = pacRepo.save(map.toModel(dto));
        return pacRepo.save(paciente);
    }
}
