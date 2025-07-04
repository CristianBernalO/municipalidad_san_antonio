package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Solicitud;
import com.example.municipalidad_san_antonio.repository.SolicitudRepository;
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
class SolicitudServiceTest {

    @Mock
    private SolicitudRepository solicitudRepository;

    @InjectMocks
    private SolicitudService solicitudService;

    private Solicitud solicitud;

    @BeforeEach
    void setUp() {
        solicitud = new Solicitud();
        solicitud.setIdSolicitud(1);
        solicitud.setNombreSolicitante("Juan Pérez");
        solicitud.setRutSolicitante("12345678-9");
        solicitud.setEstadoSolicitud("PENDIENTE");
    }

    @Test
    void testSaveSolicitud() {
        // Given
        when(solicitudRepository.save(any(Solicitud.class))).thenReturn(solicitud);

        // When
        Solicitud resultado = solicitudService.save(solicitud);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getNombreSolicitante()).isEqualTo("Juan Pérez");
        verify(solicitudRepository).save(solicitud);
    }

    @Test
    void testFindById() {
        // Given
        when(solicitudRepository.findById(1)).thenReturn(Optional.of(solicitud));

        // When
        Solicitud resultado = solicitudService.findById(1);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getIdSolicitud()).isEqualTo(1);
        verify(solicitudRepository).findById(1);
    }

    @Test
    void testFindByIdNotFound() {
        // Given
        when(solicitudRepository.findById(999)).thenReturn(Optional.empty());

        // When
        Solicitud resultado = solicitudService.findById(999);

        // Then
        assertThat(resultado).isNull();
    }

    @Test
    void testFindAll() {
        // Given
        List<Solicitud> solicitudes = Arrays.asList(solicitud);
        when(solicitudRepository.findAll()).thenReturn(solicitudes);

        // When
        List<Solicitud> resultado = solicitudService.findAll();

        // Then
        assertThat(resultado).hasSize(1);
        verify(solicitudRepository).findAll();
    }

    @Test
    void testDeleteSolicitud() {
        // Given
        doNothing().when(solicitudRepository).deleteById(1);

        // When
        solicitudService.deleteSolicitud(1);

        // Then
        verify(solicitudRepository).deleteById(1);
    }

    @Test
    void testActualizarSolicitud() {
        // Given
        Solicitud solicitudActualizada = new Solicitud();
        solicitudActualizada.setNombreSolicitante("María García");
        
        when(solicitudRepository.findById(1)).thenReturn(Optional.of(solicitud));
        when(solicitudRepository.save(any(Solicitud.class))).thenReturn(solicitudActualizada);

        // When
        String resultado = solicitudService.actualizarSolicitud(1, solicitudActualizada);

        // Then
        assertThat(resultado).isEqualTo("Solicitud actualizada");
        verify(solicitudRepository).findById(1);
        verify(solicitudRepository).save(any(Solicitud.class));
    }

    @Test
    void testActualizarSolicitudNotFound() {
        // Given
        when(solicitudRepository.findById(999)).thenReturn(Optional.empty());

        // When
        String resultado = solicitudService.actualizarSolicitud(999, solicitud);

        // Then
        assertThat(resultado).isEqualTo("Solicitud no encontrada");
        verify(solicitudRepository).findById(999);
        verify(solicitudRepository, never()).save(any());
    }

    @Test
    void testFindAllByEstadoSolicitud() {
        // Given
        List<Solicitud> solicitudes = Arrays.asList(solicitud);
        when(solicitudRepository.findByEstadoSolicitud("PENDIENTE")).thenReturn(solicitudes);

        // When
        List<Solicitud> resultado = solicitudService.findAllByEstadoSolicitud("PENDIENTE");

        // Then
        assertThat(resultado).hasSize(1);
        verify(solicitudRepository).findByEstadoSolicitud("PENDIENTE");
    }
} 