package com.example.clinica.vidasaude.respositories;

import com.example.clinica.vidasaude.models.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoasRepository extends JpaRepository<Pessoas, Integer> {
    boolean existsByNome(String nome);
}
