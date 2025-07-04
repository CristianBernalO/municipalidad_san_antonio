package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.IntegracionMinvu;
import com.example.municipalidad_san_antonio.repository.IntegracionMinvuRepository;
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
class IntegracionMinvuServiceTest {

    @Mock
    private IntegracionMinvuRepository integracionMinvuRepository;

    @InjectMocks
    private IntegracionMinvuService integracionMinvuService;

    private IntegracionMinvu integracionMinvu;

    @BeforeEach
    void setUp() {
        integracionMinvu = new IntegracionMinvu();
        integracionMinvu.setId(1);
        integracionMinvu.setExpedienteId(100);
        integracionMinvu.setEstadoEnvio("PENDIENTE");
        integracionMinvu.setFechaEnvio(LocalDateTime.now());
        integracionMinvu.setRespuestaMinvu("OK");
    }

    @Test
    void testGuardar() {
        // Given
        when(integracionMinvuRepository.save(any(IntegracionMinvu.class))).thenReturn(integracionMinvu);

        // When
        IntegracionMinvu resultado = integracionMinvuService.guardar(integracionMinvu);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getId()).isEqualTo(1);
        assertThat(resultado.getExpedienteId()).isEqualTo(100);
        assertThat(resultado.getEstadoEnvio()).isEqualTo("PENDIENTE");
        verify(integracionMinvuRepository).save(integracionMinvu);
    }

    @Test
    void testListar() {
        // Given
        List<IntegracionMinvu> integraciones = Arrays.asList(integracionMinvu);
        when(integracionMinvuRepository.findAll()).thenReturn(integraciones);

        // When
        List<IntegracionMinvu> resultado = integracionMinvuService.listar();

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getId()).isEqualTo(1);
        verify(integracionMinvuRepository).findAll();
    }

    @Test
    void testListarVacio() {
        // Given
        when(integracionMinvuRepository.findAll()).thenReturn(Arrays.asList());

        // When
        List<IntegracionMinvu> resultado = integracionMinvuService.listar();

        // Then
        assertThat(resultado).isEmpty();
        verify(integracionMinvuRepository).findAll();
    }

    @Test
    void testGuardarConDatosCompletos() {
        // Given
        IntegracionMinvu nuevaIntegracion = new IntegracionMinvu();
        nuevaIntegracion.setExpedienteId(200);
        nuevaIntegracion.setEstadoEnvio("ENVIADO");
        nuevaIntegracion.setFechaEnvio(LocalDateTime.now());
        nuevaIntegracion.setRespuestaMinvu("APROBADO");
        
        when(integracionMinvuRepository.save(any(IntegracionMinvu.class))).thenReturn(nuevaIntegracion);

        // When
        IntegracionMinvu resultado = integracionMinvuService.guardar(nuevaIntegracion);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getExpedienteId()).isEqualTo(200);
        assertThat(resultado.getEstadoEnvio()).isEqualTo("ENVIADO");
        assertThat(resultado.getRespuestaMinvu()).isEqualTo("APROBADO");
        verify(integracionMinvuRepository).save(nuevaIntegracion);
    }
} 