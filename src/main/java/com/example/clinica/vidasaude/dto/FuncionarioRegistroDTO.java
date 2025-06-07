package com.example.clinica.vidasaude.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FuncionarioRegistroDTO {
    private String nome;
    private String username;
    private String senha;
    private String cargo;
}
