package com.example.clinica.vidasaude.controllers;

import com.example.clinica.vidasaude.dto.PacienteSimplesDTO;
import com.example.clinica.vidasaude.mappers.SimpleConsultingMapper;
import com.example.clinica.vidasaude.models.Pacientes;
import com.example.clinica.vidasaude.models.Pessoas;
import com.example.clinica.vidasaude.respositories.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/pacientes")
public class PacientesController {
    @Autowired
    private PacientesRepository pacientesRepository;
    @Autowired
    private SimpleConsultingMapper simpleConsultingMapper;

    @GetMapping
    public ResponseEntity<?> listSimples(@RequestParam(value = "returnTypes", required = false) String returnTypes){
        if ("idAndNome".equals(returnTypes)){
            return ResponseEntity.ok().body(simpleConsultingMapper.toPacienteDTO(pacientesRepository.findAll()));
        } else {
            return ResponseEntity.ok().body(pacientesRepository.findAll());
        }

}}
