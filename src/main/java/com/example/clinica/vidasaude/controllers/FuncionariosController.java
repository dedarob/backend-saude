package com.example.clinica.vidasaude.controllers;

import com.example.clinica.vidasaude.dto.MedicoDTO;
import com.example.clinica.vidasaude.mappers.SimpleConsultingMapper;
import com.example.clinica.vidasaude.respositories.FuncionariosRepository;
import com.example.clinica.vidasaude.services.AuthService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/funcionarios")
public class FuncionariosController{
    @Autowired
    private FuncionariosRepository funcionariosRepository;
    @Autowired
    private SimpleConsultingMapper simpleConsultingMapper;
    @Autowired
    private AuthService serviceAuth;

@GetMapping
public ResponseEntity<?> listSimples(@RequestParam(value = "returnTypes", required = false) String returnTypes){
    if ("idAndNome".equals(returnTypes)){
        return ResponseEntity.ok().body(simpleConsultingMapper.toFuncionarioDTO(funcionariosRepository.findAll()));
    } if ("medicoSimples".equals((returnTypes))){
        return ResponseEntity.ok().body(serviceAuth.retornarMedicoSimples());
    }
    else {
        return ResponseEntity.ok().body(funcionariosRepository.findAll());
    }
}
}




