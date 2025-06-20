package com.example.clinica.vidasaude.controllers;

import com.example.clinica.vidasaude.dto.ConsultasDTO;
import com.example.clinica.vidasaude.dto.RegistrarConsultasDTO;
import com.example.clinica.vidasaude.models.Atendimentos;
import com.example.clinica.vidasaude.models.Consultas;
import com.example.clinica.vidasaude.services.ConsultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/consultas")
public class ConsultasController {
    @Autowired
    private ConsultasService consultasService;

    @GetMapping
    public ResponseEntity<List<ConsultasDTO>> listarConsultas(){
        return ResponseEntity.ok(consultasService.puxarTodasConsultas());
    }

    @PostMapping
    public ResponseEntity<Consultas> regConsultas(@RequestBody RegistrarConsultasDTO dto){

        return ResponseEntity.ok().body(consultasService.registrarConsultas(dto));
    }
}
