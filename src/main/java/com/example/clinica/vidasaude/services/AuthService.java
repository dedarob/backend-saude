package com.example.clinica.vidasaude.services;

import com.example.clinica.vidasaude.dto.AuthDTO;
import com.example.clinica.vidasaude.models.Funcionarios;
import com.example.clinica.vidasaude.respositories.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private FuncionariosRepository funRepo;

    public Integer acharUsuarioEAutenticar(AuthDTO dto){
        Optional<Funcionarios> funcionarios = funRepo.findByUsername(dto.getUsername());
        if (!funcionarios.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        Funcionarios funcionarioMod = funcionarios.get();
        if (!funcionarioMod.getSenha().equals(dto.getSenha())){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Senha incorreta");
        }
        return funcionarioMod.getId();
    }
}
