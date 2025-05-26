package com.example.clinica.vidasaude.controllers;

import com.example.clinica.vidasaude.models.Medicamentos;
import com.example.clinica.vidasaude.services.MedicamentosService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/medicamentos")
public class MedicamentosController {
    @Autowired
    private MedicamentosService medicamentosService;

    @GetMapping
    public ResponseEntity<List<Medicamentos>> listarMedicamentos(){
        return ResponseEntity.ok().body(medicamentosService.puxarTodosMedicamentos());
    }

}
