package com.example.clinica.vidasaude.services;

import com.example.clinica.vidasaude.dto.ConsultasDTO;
import com.example.clinica.vidasaude.dto.RegistrarConsultasDTO;
import com.example.clinica.vidasaude.mappers.ConsultasMapper;
import com.example.clinica.vidasaude.models.Atendimentos;
import com.example.clinica.vidasaude.models.Consultas;
import com.example.clinica.vidasaude.models.Medicos;
import com.example.clinica.vidasaude.respositories.AtendimentosRepository;
import com.example.clinica.vidasaude.respositories.ConsultasRepository;
import com.example.clinica.vidasaude.respositories.MedicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultasService {
    @Autowired
    private ConsultasMapper consultasMapper;
    @Autowired
    private ConsultasRepository consultasRepository;
    @Autowired
    private AtendimentosRepository atendimentosRepository;
    @Autowired
    private MedicosRepository medicosRepository;

    public List<ConsultasDTO> puxarTodasConsultas(){
        List<Consultas> consultas = (List<Consultas>) consultasRepository.findAll();
        consultas.forEach(c -> System.out.println("Consulta id: " + c.getId()));
        return consultasMapper.toDTO(consultas);
    }

    public Consultas registrarConsultas(RegistrarConsultasDTO dto){
        Atendimentos atendimento = atendimentosRepository.findById(dto.getAtendimentoId()).get();
        Medicos medico = medicosRepository.findById(dto.getMedicoId()).get();
        Consultas consulta = new Consultas();
        consulta.setAtendimento(atendimento);
        consulta.setMedico(medico);
        consulta.setData(dto.getData());
        consulta.setStatus(dto.getStatus());
        consultasRepository.save(consulta);
        return consulta;
    }
}
