package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Expediente;
import com.example.municipalidad_san_antonio.repository.ExpedienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExpedienteServiceTest {

    @Mock
    private ExpedienteRepository expedienteRepository;

    @InjectMocks
    private ExpedienteService expedienteService;

    private Expediente expediente;

    @BeforeEach
    void setUp() {
        expediente = new Expediente();
        expediente.setId(1);
        expediente.setNumeroExpediente("EXP-2024-001");
        expediente.setFechaCreacion(LocalDateTime.now());
        expediente.setEstado("ACTIVO");
        expediente.setSolicitudId(1);
    }

    @Test
    void testGuardarExpediente() {
        // Given
        when(expedienteRepository.save(any(Expediente.class))).thenReturn(expediente);

        // When
        Expediente resultado = expedienteService.guardar(expediente);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getNumeroExpediente()).isEqualTo("EXP-2024-001");
        assertThat(resultado.getEstado()).isEqualTo("ACTIVO");
        verify(expedienteRepository).save(expediente);
    }

    @Test
    void testListarExpedientes() {
        // Given
        List<Expediente> expedientes = Arrays.asList(expediente);
        when(expedienteRepository.findAll()).thenReturn(expedientes);

        // When
        List<Expediente> resultado = expedienteService.listar();

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getNumeroExpediente()).isEqualTo("EXP-2024-001");
        verify(expedienteRepository).findAll();
    }
} 