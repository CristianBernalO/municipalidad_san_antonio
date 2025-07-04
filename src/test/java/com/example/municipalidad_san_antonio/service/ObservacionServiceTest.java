package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Observacion;
import com.example.municipalidad_san_antonio.repository.ObservacionRepository;
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
class ObservacionServiceTest {

    @Mock
    private ObservacionRepository observacionRepository;

    @InjectMocks
    private ObservacionService observacionService;

    private Observacion observacion;

    @BeforeEach
    void setUp() {
        observacion = new Observacion();
        observacion.setId(1);
        observacion.setSolicitudId(1);
        observacion.setDescripcion("Faltan planos de cimentación");
        observacion.setTipo("TECNICA");
        observacion.setFechaCreacion(LocalDateTime.now());
        observacion.setEstado("ABIERTA");
    }

    @Test
    void testGuardarObservacion() {
        // Given
        when(observacionRepository.save(any(Observacion.class))).thenReturn(observacion);

        // When
        Observacion resultado = observacionService.guardar(observacion);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getDescripcion()).isEqualTo("Faltan planos de cimentación");
        assertThat(resultado.getEstado()).isEqualTo("ABIERTA");
        verify(observacionRepository).save(observacion);
    }

    @Test
    void testListarObservaciones() {
        // Given
        List<Observacion> observaciones = Arrays.asList(observacion);
        when(observacionRepository.findAll()).thenReturn(observaciones);

        // When
        List<Observacion> resultado = observacionService.listar();

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getDescripcion()).isEqualTo("Faltan planos de cimentación");
        verify(observacionRepository).findAll();
    }
} 