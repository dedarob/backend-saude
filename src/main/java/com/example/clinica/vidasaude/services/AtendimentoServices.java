package com.example.clinica.vidasaude.services;

import com.example.clinica.vidasaude.dto.AtendimentosDTO;
import com.example.clinica.vidasaude.mappers.AtendimentosMapper;
import com.example.clinica.vidasaude.models.Atendimentos;
import com.example.clinica.vidasaude.respositories.AtendimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoServices{
    @Autowired
    private AtendimentosRepository atendimentosRepository;
    @Autowired
    private AtendimentosMapper atendimentosMapper;

    public List<AtendimentosDTO> getAllAtendimentos(){
       List<Atendimentos> atendimentos = (List<Atendimentos>) atendimentosRepository.findAll();
       return atendimentosMapper.toDTO(atendimentos);
    }
}
