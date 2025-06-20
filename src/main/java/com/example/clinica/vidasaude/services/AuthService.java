package com.example.clinica.vidasaude.services;

import com.example.clinica.vidasaude.dto.AuthDTO;
import com.example.clinica.vidasaude.dto.FuncionarioRegistroDTO;
import com.example.clinica.vidasaude.dto.MedicoDTO;
import com.example.clinica.vidasaude.dto.MedicoSimplesDTO;
import com.example.clinica.vidasaude.mappers.SimpleConsultingMapper;
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

import java.util.ArrayList;
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
    @Autowired
    private SimpleConsultingMapper simpleMapper;
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
        if(!funRepo.existsById(dto.getIdFuncionario())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado");
        }
        Funcionarios funcionario = funRepo.findById(dto.getIdFuncionario()).get();
        if(!funcionario.getCargo().equalsIgnoreCase("medico")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Funcionario não é um médico");
        }
        //Pessoas pessoa = pessoasRepo.findById(funcionario.getPessoa().getId()).get();
        Medicos medico = new Medicos();
        medico.setFuncionario(funcionario);
        medico.setEspecialidade(dto.getRamo());
        medRepo.save(medico);
        return medico;
    }

    public List<MedicoSimplesDTO> retornarMedicoSimples(){
        List<Medicos> medicos = medRepo.findAll();
        return simpleMapper.toMedicoSimplesDTO(medicos);
    }
}
