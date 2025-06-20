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
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        consultas.forEach(c -> System.out.println("Consulta hora: " + c.getHora()));
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
        consulta.setHora(dto.getHora());
        consultasRepository.save(consulta);
        return consulta;
    }

    public Consultas alterarConsultas(Integer id, RegistrarConsultasDTO dto){
        Consultas consulta = consultasRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consulta não existe"));

        Atendimentos atendimento = atendimentosRepository.findById(dto.getAtendimentoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Atendimento não encontrado"));

        Medicos medico = medicosRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado"));

        consulta.setAtendimento(atendimento);
        consulta.setMedico(medico);
        consulta.setData(dto.getData());
        consulta.setStatus(dto.getStatus());
        consulta.setHora(dto.getHora());

        return consultasRepository.save(consulta);
    }
}
