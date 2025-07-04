package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Bitacora;
import com.example.municipalidad_san_antonio.repository.BitacoraRepository;
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
class BitacoraServiceTest {

    @Mock
    private BitacoraRepository bitacoraRepository;

    @InjectMocks
    private BitacoraService bitacoraService;

    private Bitacora bitacora;

    @BeforeEach
    void setUp() {
        bitacora = new Bitacora();
        bitacora.setId(1);
        bitacora.setAccion("CREAR_SOLICITUD");
        bitacora.setFechaAccion(LocalDateTime.now());
        bitacora.setUsuario("usuario1");
        bitacora.setDescripcion("Se creó una nueva solicitud");
        bitacora.setExpedienteId(123);
    }

    @Test
    void testGuardarBitacora() {
        // Given
        when(bitacoraRepository.save(any(Bitacora.class))).thenReturn(bitacora);

        // When
        Bitacora resultado = bitacoraService.guardar(bitacora);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getAccion()).isEqualTo("CREAR_SOLICITUD");
        assertThat(resultado.getDescripcion()).isEqualTo("Se creó una nueva solicitud");
        assertThat(resultado.getUsuario()).isEqualTo("usuario1");
        assertThat(resultado.getExpedienteId()).isEqualTo(123);
        verify(bitacoraRepository).save(bitacora);
    }

    @Test
    void testListarBitacoras() {
        // Given
        List<Bitacora> bitacoras = Arrays.asList(bitacora);
        when(bitacoraRepository.findAll()).thenReturn(bitacoras);

        // When
        List<Bitacora> resultado = bitacoraService.listar();

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getAccion()).isEqualTo("CREAR_SOLICITUD");
        assertThat(resultado.get(0).getUsuario()).isEqualTo("usuario1");
        verify(bitacoraRepository).findAll();
    }

    @Test
    void testGuardarBitacoraConDatosNulos() {
        // Given
        Bitacora bitacoraNula = new Bitacora();
        when(bitacoraRepository.save(any(Bitacora.class))).thenReturn(bitacoraNula);

        // When
        Bitacora resultado = bitacoraService.guardar(bitacoraNula);

        // Then
        assertThat(resultado).isNotNull();
        verify(bitacoraRepository).save(bitacoraNula);
    }

    @Test
    void testListarBitacorasVacia() {
        // Given
        when(bitacoraRepository.findAll()).thenReturn(Arrays.asList());

        // When
        List<Bitacora> resultado = bitacoraService.listar();

        // Then
        assertThat(resultado).isEmpty();
        verify(bitacoraRepository).findAll();
    }
} 