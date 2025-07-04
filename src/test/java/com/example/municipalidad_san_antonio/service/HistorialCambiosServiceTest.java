package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.HistorialCambios;
import com.example.municipalidad_san_antonio.repository.HistorialCambiosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HistorialCambiosServiceTest {

    @Mock
    private HistorialCambiosRepository historialCambiosRepository;

    @InjectMocks
    private HistorialCambiosService historialCambiosService;

    private HistorialCambios historialCambios;

    @BeforeEach
    void setUp() {
        historialCambios = new HistorialCambios();
        historialCambios.setId(1);
        historialCambios.setEntidad("SOLICITUD");
        historialCambios.setEntidadId(1);
        historialCambios.setUsuario("usuario@test.com");
        historialCambios.setTipoCambio("ESTADO");
        historialCambios.setValorAnterior("PENDIENTE");
        historialCambios.setValorNuevo("APROBADO");
        historialCambios.setFechaCambio(LocalDateTime.now());
    }

    @Test
    void testGuardarHistorialCambios() {
        // Given
        when(historialCambiosRepository.save(any(HistorialCambios.class))).thenReturn(historialCambios);

        // When
        HistorialCambios resultado = historialCambiosService.guardar(historialCambios);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getEntidad()).isEqualTo("SOLICITUD");
        assertThat(resultado.getTipoCambio()).isEqualTo("ESTADO");
        assertThat(resultado.getValorAnterior()).isEqualTo("PENDIENTE");
        assertThat(resultado.getValorNuevo()).isEqualTo("APROBADO");
        verify(historialCambiosRepository).save(historialCambios);
    }

    @Test
    void testListarHistorialCambios() {
        // Given
        List<HistorialCambios> historiales = Arrays.asList(historialCambios);
        when(historialCambiosRepository.findAll()).thenReturn(historiales);

        // When
        List<HistorialCambios> resultado = historialCambiosService.listar();

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getEntidad()).isEqualTo("SOLICITUD");
        assertThat(resultado.get(0).getTipoCambio()).isEqualTo("ESTADO");
        verify(historialCambiosRepository).findAll();
    }

    @Test
    void testGuardarHistorialCambiosConDatosCompletos() {
        // Given
        HistorialCambios nuevoHistorial = new HistorialCambios();
        nuevoHistorial.setEntidad("EXPEDIENTE");
        nuevoHistorial.setEntidadId(123);
        nuevoHistorial.setUsuario("admin@municipalidad.cl");
        nuevoHistorial.setTipoCambio("ESTADO_DOCUMENTO");
        nuevoHistorial.setValorAnterior("BORRADOR");
        nuevoHistorial.setValorNuevo("FINALIZADO");
        nuevoHistorial.setFechaCambio(LocalDateTime.now());
        
        when(historialCambiosRepository.save(any(HistorialCambios.class))).thenReturn(nuevoHistorial);

        // When
        HistorialCambios resultado = historialCambiosService.guardar(nuevoHistorial);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getEntidad()).isEqualTo("EXPEDIENTE");
        assertThat(resultado.getEntidadId()).isEqualTo(123);
        assertThat(resultado.getUsuario()).isEqualTo("admin@municipalidad.cl");
        assertThat(resultado.getTipoCambio()).isEqualTo("ESTADO_DOCUMENTO");
        assertThat(resultado.getValorAnterior()).isEqualTo("BORRADOR");
        assertThat(resultado.getValorNuevo()).isEqualTo("FINALIZADO");
        verify(historialCambiosRepository).save(nuevoHistorial);
    }

    @Test
    void testListarHistorialCambiosVacio() {
        // Given
        when(historialCambiosRepository.findAll()).thenReturn(Arrays.asList());

        // When
        List<HistorialCambios> resultado = historialCambiosService.listar();

        // Then
        assertThat(resultado).isEmpty();
        verify(historialCambiosRepository).findAll();
    }
} 