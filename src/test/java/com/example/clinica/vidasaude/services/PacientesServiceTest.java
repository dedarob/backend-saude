package com.example.clinica.vidasaude.services;

import com.example.clinica.vidasaude.dto.PacienteCompletoDTO;
import com.example.clinica.vidasaude.mappers.PacienteMapper;
import com.example.clinica.vidasaude.models.Pacientes;
import com.example.clinica.vidasaude.models.Pessoas;
import com.example.clinica.vidasaude.respositories.PacientesRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PacientesServiceTest {

    @Mock
    private PacientesRepository pacRepo;

    @Mock
    private PacienteMapper map;

    @InjectMocks
    private PacientesService service;
    public PacientesServiceTest(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testCadastrarPaciente() {
        PacienteCompletoDTO dto = new PacienteCompletoDTO();
        dto.setNomePaciente("João Silva");

        Pessoas pessoa = new Pessoas();
        pessoa.setNome("João Silva");

        Pacientes paciente = new Pacientes();
        paciente.setPessoa(pessoa);

        when(map.toModel(dto)).thenReturn(paciente);
        when(pacRepo.save(paciente)).thenReturn(paciente);

        Pacientes resultado = service.cadastrarPaciente(dto);

        assertNotNull(resultado);
        assertEquals("João Silva", resultado.getPessoa().getNome());
        verify(map, times(1)).toModel(dto);
        verify(pacRepo, times(1)).save(paciente);
    }
}