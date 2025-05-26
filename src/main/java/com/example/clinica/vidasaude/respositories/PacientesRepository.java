package com.example.clinica.vidasaude.respositories;

import com.example.clinica.vidasaude.models.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PacientesRepository extends JpaRepository<Pacientes, Integer> {
}
