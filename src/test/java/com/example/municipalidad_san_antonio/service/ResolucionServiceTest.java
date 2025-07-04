package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Resolucion;
import com.example.municipalidad_san_antonio.repository.ResolucionRepository;
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
class ResolucionServiceTest {

    @Mock
    private ResolucionRepository resolucionRepository;

    @InjectMocks
    private ResolucionService resolucionService;

    private Resolucion resolucion;

    @BeforeEach
    void setUp() {
        resolucion = new Resolucion();
        resolucion.setId(1);
        resolucion.setSolicitudId(1);
        resolucion.setTipo("APROBACION");
        resolucion.setDescripcion("Resolución de aprobación del proyecto");
        resolucion.setFechaResolucion(LocalDateTime.now());
    }

    @Test
    void testGuardarResolucion() {
        // Given
        when(resolucionRepository.save(any(Resolucion.class))).thenReturn(resolucion);

        // When
        Resolucion resultado = resolucionService.guardar(resolucion);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getTipo()).isEqualTo("APROBACION");
        assertThat(resultado.getDescripcion()).isEqualTo("Resolución de aprobación del proyecto");
        verify(resolucionRepository).save(resolucion);
    }

    @Test
    void testListarResoluciones() {
        // Given
        List<Resolucion> resoluciones = Arrays.asList(resolucion);
        when(resolucionRepository.findAll()).thenReturn(resoluciones);

        // When
        List<Resolucion> resultado = resolucionService.listar();

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getTipo()).isEqualTo("APROBACION");
        verify(resolucionRepository).findAll();
    }
} 