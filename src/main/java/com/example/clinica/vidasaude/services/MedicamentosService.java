package com.example.clinica.vidasaude.services;

import com.example.clinica.vidasaude.models.Medicamentos;
import com.example.clinica.vidasaude.respositories.MedicamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MedicamentosService {
    @Autowired
    private MedicamentosRepository medicamentosRepository;

    public List<Medicamentos> puxarTodosMedicamentos(){
        List<Medicamentos> listaMedicamentos = (List<Medicamentos>) medicamentosRepository.findAll();
        return listaMedicamentos;
    }

    public Medicamentos inserirMedicamento(Medicamentos medicamento){
        medicamentosRepository.save(medicamento);
        return medicamento;
    }

    public Medicamentos modificarMedicamento(Integer id, Medicamentos medicamento){
        if (medicamentosRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicamento não encontrado");
        }
        medicamento.setId(id);
        medicamentosRepository.save(medicamento);
        return medicamento;
    }
}
