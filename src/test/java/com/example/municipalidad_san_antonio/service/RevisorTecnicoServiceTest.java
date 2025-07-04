package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.RevisorTecnico;
import com.example.municipalidad_san_antonio.repository.RevisorTecnicoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RevisorTecnicoServiceTest {

    @Mock
    private RevisorTecnicoRepository revisorTecnicoRepository;

    @InjectMocks
    private RevisorTecnicoService revisorTecnicoService;

    private RevisorTecnico revisorTecnico;

    @BeforeEach
    void setUp() {
        revisorTecnico = new RevisorTecnico();
        revisorTecnico.setIdRevisor(1);
        revisorTecnico.setNombre("Juan");
        revisorTecnico.setApellido("Pérez");
        revisorTecnico.setEmail("juan.perez@example.com");
    }

    @Test
    void testSaveRevisorTecnico() {
        // Given
        when(revisorTecnicoRepository.save(any(RevisorTecnico.class))).thenReturn(revisorTecnico);

        // When
        RevisorTecnico resultado = revisorTecnicoService.save(revisorTecnico);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getNombre()).isEqualTo("Juan");
        assertThat(resultado.getApellido()).isEqualTo("Pérez");
        verify(revisorTecnicoRepository).save(revisorTecnico);
    }

    @Test
    void testFindAllRevisoresTecnicos() {
        // Given
        List<RevisorTecnico> revisores = Arrays.asList(revisorTecnico);
        when(revisorTecnicoRepository.findAll()).thenReturn(revisores);

        // When
        List<RevisorTecnico> resultado = revisorTecnicoService.findAll();

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getNombre()).isEqualTo("Juan");
        verify(revisorTecnicoRepository).findAll();
    }

    @Test
    void testFindById() {
        // Given
        when(revisorTecnicoRepository.findById(1)).thenReturn(revisorTecnico);

        // When
        RevisorTecnico resultado = revisorTecnicoService.findById(1);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getNombre()).isEqualTo("Juan");
        verify(revisorTecnicoRepository).findById(1);
    }

    @Test
    void testFindByNombre() {
        // Given
        List<RevisorTecnico> revisores = Arrays.asList(revisorTecnico);
        when(revisorTecnicoRepository.findByNombre("Juan")).thenReturn(revisores);

        // When
        List<RevisorTecnico> resultado = revisorTecnicoService.findByNombre("Juan");

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getNombre()).isEqualTo("Juan");
        verify(revisorTecnicoRepository).findByNombre("Juan");
    }

    @Test
    void testFindByEmail() {
        // Given
        when(revisorTecnicoRepository.findByEmail("juan.perez@example.com")).thenReturn(revisorTecnico);

        // When
        RevisorTecnico resultado = revisorTecnicoService.findByEmail("juan.perez@example.com");

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getEmail()).isEqualTo("juan.perez@example.com");
        verify(revisorTecnicoRepository).findByEmail("juan.perez@example.com");
    }

    @Test
    void testDeleteRevisorTecnico() {
        // Given
        Integer idRevisor = 1;
        doNothing().when(revisorTecnicoRepository).deleteById(idRevisor);

        // When
        revisorTecnicoService.delete(idRevisor);

        // Then
        verify(revisorTecnicoRepository).deleteById(idRevisor);
    }
} 