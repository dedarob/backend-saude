package com.example.clinica.vidasaude.controllers;

import com.example.clinica.vidasaude.dto.AtendimentosDTO;
import com.example.clinica.vidasaude.respositories.AtendimentosRepository;
import com.example.clinica.vidasaude.services.AtendimentoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/atendimentos")
public class AtendimentosController {
    @Autowired
    private AtendimentoServices atendimentoServices;

    @GetMapping
    public ResponseEntity<List<AtendimentosDTO>> listarAtendimentos(){
        List<AtendimentosDTO> atendimento = atendimentoServices.getAllAtendimentos();
        return ResponseEntity.ok().body(atendimento);
    }
}
