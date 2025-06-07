package com.example.clinica.vidasaude.services;

import com.example.clinica.vidasaude.dto.AuthDTO;
import com.example.clinica.vidasaude.dto.FuncionarioRegistroDTO;
import com.example.clinica.vidasaude.dto.MedicoDTO;
import com.example.clinica.vidasaude.models.Funcionarios;
import com.example.clinica.vidasaude.models.Medicos;
import com.example.clinica.vidasaude.models.Pessoas;
import com.example.clinica.vidasaude.respositories.FuncionariosRepository;
import com.example.clinica.vidasaude.respositories.MedicosRepository;
import com.example.clinica.vidasaude.respositories.PessoasRepository;
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
    @Autowired
    private PessoasRepository pessoasRepo;
    @Autowired
    private MedicosRepository medRepo;
    public Integer acharUsuarioEAutenticar(AuthDTO dto){
        Optional<Funcionarios> funcionarios = funRepo.findByUsername(dto.getUsername());
        System.out.println("aquibeto" + dto.getUsername());
        if (!funcionarios.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        Funcionarios funcionarioMod = funcionarios.get();
        if (!funcionarioMod.getSenha().equals(dto.getSenha())){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Senha incorreta");
        }
        return funcionarioMod.getId();
    }

    public Funcionarios registrarFuncionario(FuncionarioRegistroDTO dto){
        if(funRepo.existsByUsername(dto.getUsername())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe");
        }
        Pessoas pessoa = new Pessoas();
        Funcionarios funcionarios = new Funcionarios();
        pessoa.setNome(dto.getNome());
        pessoasRepo.save(pessoa);
        funcionarios.setPessoa(pessoa);
        funcionarios.setCargo(dto.getCargo());
        funcionarios.setSenha(dto.getSenha());
        funcionarios.setUsername(dto.getUsername());
        funRepo.save(funcionarios);
        return funcionarios;
    }

    public Medicos salvarMedicoRamo(MedicoDTO dto){
        if(!pessoasRepo.existsById(dto.getIdPessoa())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada");
        }
        Pessoas pessoa = pessoasRepo.findById(dto.getIdPessoa()).get();
        Medicos medico = new Medicos();
        medico.setPessoa(pessoa);
        medico.setCargo(dto.getRamo());
        medRepo.save(medico);
        return medico;
    }
}
