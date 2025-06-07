package com.example.clinica.vidasaude.controllers;

import com.example.clinica.vidasaude.dto.AuthDTO;
import com.example.clinica.vidasaude.dto.FuncionarioRegistroDTO;
import com.example.clinica.vidasaude.dto.MedicoDTO;
import com.example.clinica.vidasaude.models.Funcionarios;
import com.example.clinica.vidasaude.respositories.FuncionariosRepository;
import com.example.clinica.vidasaude.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sec")
@CrossOrigin("*")
public class AuthenticationController {
    //camada de segurança feita somente para demonstração, isso não é adequado para builds de produção
    @Autowired
    private AuthService service;
    @Autowired
    private FuncionariosRepository repo;
    @PostMapping
    public ResponseEntity login(@RequestBody AuthDTO dto){
        return  ResponseEntity.ok().body(service.acharUsuarioEAutenticar(dto));
    }

    @GetMapping ResponseEntity contextNome(Integer id){
        Funcionarios func = repo.findById(id).get();
        return ResponseEntity.ok().body(func.getPessoa().getNome());
    }

    @PostMapping("/registrar") ResponseEntity<Funcionarios> registrarFuncionario(@RequestBody FuncionarioRegistroDTO dto){
        return ResponseEntity.ok().body(service.registrarFuncionario(dto));
    }

    @PostMapping("/medicos")
    public ResponseEntity<?> registrarMedico(@RequestBody MedicoDTO dto){
        return ResponseEntity.ok().body(service.salvarMedicoRamo(dto));
}
}
