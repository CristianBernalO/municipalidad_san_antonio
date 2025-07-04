package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Notificacion;
import com.example.municipalidad_san_antonio.repository.NotificacionRepository;
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
class NotificacionServiceTest {

    @Mock
    private NotificacionRepository notificacionRepository;

    @InjectMocks
    private NotificacionService notificacionService;

    private Notificacion notificacion;

    @BeforeEach
    void setUp() {
        notificacion = new Notificacion();
        notificacion.setId(1);
        notificacion.setDestinatario("usuario@ejemplo.com");
        notificacion.setTipo("EMAIL");
        notificacion.setMensaje("Su solicitud ha sido aprobada");
        notificacion.setFechaEnvio(LocalDateTime.now());
        notificacion.setEnviada(false);
    }

    @Test
    void testGuardarNotificacion() {
        // Given
        when(notificacionRepository.save(any(Notificacion.class))).thenReturn(notificacion);

        // When
        Notificacion resultado = notificacionService.guardar(notificacion);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getDestinatario()).isEqualTo("usuario@ejemplo.com");
        assertThat(resultado.getTipo()).isEqualTo("EMAIL");
        assertThat(resultado.getMensaje()).isEqualTo("Su solicitud ha sido aprobada");
        verify(notificacionRepository).save(notificacion);
    }

    @Test
    void testListarNotificaciones() {
        // Given
        List<Notificacion> notificaciones = Arrays.asList(notificacion);
        when(notificacionRepository.findAll()).thenReturn(notificaciones);

        // When
        List<Notificacion> resultado = notificacionService.listar();

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getDestinatario()).isEqualTo("usuario@ejemplo.com");
        assertThat(resultado.get(0).getTipo()).isEqualTo("EMAIL");
        verify(notificacionRepository).findAll();
    }
} 