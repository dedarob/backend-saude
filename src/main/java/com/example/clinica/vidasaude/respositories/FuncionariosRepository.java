package com.example.clinica.vidasaude.respositories;

import com.example.clinica.vidasaude.models.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionariosRepository extends JpaRepository<Funcionarios, Integer> {
    Optional findByUsername(String username);
    boolean existsByUsername(String username);
}
