package com.example.clinica.vidasaude.services;

import com.example.clinica.vidasaude.models.Medicamentos;
import com.example.clinica.vidasaude.respositories.MedicamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentosService {
    @Autowired
    private MedicamentosRepository medicamentosRepository;

    public List<Medicamentos> puxarTodosMedicamentos(){
        List<Medicamentos> listaMedicamentos = (List<Medicamentos>) medicamentosRepository.findAll();
        return listaMedicamentos;
    }
}
