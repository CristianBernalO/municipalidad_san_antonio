package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Seguimiento;
import com.example.municipalidad_san_antonio.model.Solicitud;
import com.example.municipalidad_san_antonio.repository.SeguimientoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SeguimientoServiceTest {

    @Mock
    private SeguimientoRepository seguimientoRepository;

    @Mock
    private SolicitudService solicitudService;

    @InjectMocks
    private SeguimientoService seguimientoService;

    private Seguimiento seguimiento;
    private Solicitud solicitud;

    @BeforeEach
    void setUp() {
        seguimiento = new Seguimiento();
        seguimiento.setId(1);
        seguimiento.setEstado("EN_REVISION");
        seguimiento.setMensaje("En revisión técnica");

        solicitud = new Solicitud();
        solicitud.setIdSolicitud(1);
        solicitud.setEstadoSolicitud("EN_REVISION");
        solicitud.setObservacionSolicitud("En revisión técnica");
    }

    @Test
    void testGetSeguimiento() {
        // Given
        when(solicitudService.findById(1)).thenReturn(solicitud);

        // When
        Seguimiento resultado = seguimientoService.getSeguimiento(1);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getId()).isEqualTo(1);
        assertThat(resultado.getEstado()).isEqualTo("EN_REVISION");
        assertThat(resultado.getMensaje()).isEqualTo("En revisión técnica");
        verify(solicitudService).findById(1);
    }

    @Test
    void testGetSeguimientoConSolicitudNoEncontrada() {
        // Given
        when(solicitudService.findById(999)).thenReturn(null);

        // When
        Seguimiento resultado = seguimientoService.getSeguimiento(999);

        // Then
        assertThat(resultado).isNotNull();
        // El seguimiento se crea pero con valores null porque la solicitud no existe
        verify(solicitudService).findById(999);
    }
} 