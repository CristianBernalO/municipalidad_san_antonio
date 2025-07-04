package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.ValidacionDocumental;
import com.example.municipalidad_san_antonio.repository.ValidacionDocumentalRepository;
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
class ValidacionDocumentalServiceTest {

    @Mock
    private ValidacionDocumentalRepository validacionDocumentalRepository;

    @InjectMocks
    private ValidacionDocumentalService validacionDocumentalService;

    private ValidacionDocumental validacionDocumental;

    @BeforeEach
    void setUp() {
        validacionDocumental = new ValidacionDocumental();
        validacionDocumental.setId(1);
        validacionDocumental.setDocumentoId(100);
        validacionDocumental.setValido(true);
        validacionDocumental.setObservaciones("Documento válido");
        validacionDocumental.setFechaValidacion(LocalDateTime.now());
    }

    @Test
    void testGuardar() {
        // Given
        when(validacionDocumentalRepository.save(any(ValidacionDocumental.class))).thenReturn(validacionDocumental);

        // When
        ValidacionDocumental resultado = validacionDocumentalService.guardar(validacionDocumental);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getId()).isEqualTo(1);
        assertThat(resultado.getDocumentoId()).isEqualTo(100);
        assertThat(resultado.isValido()).isTrue();
        assertThat(resultado.getObservaciones()).isEqualTo("Documento válido");
        verify(validacionDocumentalRepository).save(validacionDocumental);
    }

    @Test
    void testListar() {
        // Given
        List<ValidacionDocumental> validaciones = Arrays.asList(validacionDocumental);
        when(validacionDocumentalRepository.findAll()).thenReturn(validaciones);

        // When
        List<ValidacionDocumental> resultado = validacionDocumentalService.listar();

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getId()).isEqualTo(1);
        verify(validacionDocumentalRepository).findAll();
    }

    @Test
    void testListarVacio() {
        // Given
        when(validacionDocumentalRepository.findAll()).thenReturn(Arrays.asList());

        // When
        List<ValidacionDocumental> resultado = validacionDocumentalService.listar();

        // Then
        assertThat(resultado).isEmpty();
        verify(validacionDocumentalRepository).findAll();
    }

    @Test
    void testGuardarValidacionInvalida() {
        // Given
        ValidacionDocumental validacionInvalida = new ValidacionDocumental();
        validacionInvalida.setDocumentoId(200);
        validacionInvalida.setValido(false);
        validacionInvalida.setObservaciones("Documento inválido - faltan firmas");
        validacionInvalida.setFechaValidacion(LocalDateTime.now());
        
        when(validacionDocumentalRepository.save(any(ValidacionDocumental.class))).thenReturn(validacionInvalida);

        // When
        ValidacionDocumental resultado = validacionDocumentalService.guardar(validacionInvalida);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getDocumentoId()).isEqualTo(200);
        assertThat(resultado.isValido()).isFalse();
        assertThat(resultado.getObservaciones()).isEqualTo("Documento inválido - faltan firmas");
        verify(validacionDocumentalRepository).save(validacionInvalida);
    }

    @Test
    void testGuardarConFechaValidacion() {
        // Given
        LocalDateTime fechaEspecifica = LocalDateTime.of(2024, 1, 15, 10, 30);
        validacionDocumental.setFechaValidacion(fechaEspecifica);
        
        when(validacionDocumentalRepository.save(any(ValidacionDocumental.class))).thenReturn(validacionDocumental);

        // When
        ValidacionDocumental resultado = validacionDocumentalService.guardar(validacionDocumental);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getFechaValidacion()).isEqualTo(fechaEspecifica);
        verify(validacionDocumentalRepository).save(validacionDocumental);
    }
} 