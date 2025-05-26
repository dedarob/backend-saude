package com.example.clinica.vidasaude.services;

import com.example.clinica.vidasaude.dto.ConsultasDTO;
import com.example.clinica.vidasaude.mappers.ConsultasMapper;
import com.example.clinica.vidasaude.models.Consultas;
import com.example.clinica.vidasaude.respositories.ConsultasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultasService {
    @Autowired
    private ConsultasMapper consultasMapper;
    @Autowired
    private ConsultasRepository consultasRepository;

    public List<ConsultasDTO> puxarTodasConsultas(){
        List<Consultas> consultas = (List<Consultas>) consultasRepository.findAll();
        return consultasMapper.toDTO(consultas);
    }
}
