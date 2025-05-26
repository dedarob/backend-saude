package com.example.clinica.vidasaude.controllers;

import com.example.clinica.vidasaude.dto.AtendimentosDTO;
import com.example.clinica.vidasaude.dto.AtendimentosRequestDTO;
import com.example.clinica.vidasaude.models.Atendimentos;
import com.example.clinica.vidasaude.respositories.AtendimentosRepository;
import com.example.clinica.vidasaude.services.AtendimentoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Atendimentos> registrarAtendimento(@RequestBody AtendimentosRequestDTO dto){
        try{
        Atendimentos atendimento = atendimentoServices.registrarAtendimento(dto);
        return ResponseEntity.status(201).body(atendimento);
        } catch (Exception e){
            System.out.println("Erro no controller");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
