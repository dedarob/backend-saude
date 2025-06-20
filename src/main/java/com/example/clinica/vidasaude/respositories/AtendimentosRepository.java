package com.example.clinica.vidasaude.respositories;

import com.example.clinica.vidasaude.models.Atendimentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AtendimentosRepository extends JpaRepository<Atendimentos, Integer> {
}
