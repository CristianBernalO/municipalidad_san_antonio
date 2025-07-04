package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Archivo;
import com.example.municipalidad_san_antonio.repository.ArchivoRepository;
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
class ArchivoServiceTest {

    @Mock
    private ArchivoRepository archivoRepository;

    @InjectMocks
    private ArchivoService archivoService;

    private Archivo archivo;

    @BeforeEach
    void setUp() {
        archivo = new Archivo();
        archivo.setId(1);
        archivo.setNombreArchivo("documento.pdf");
        archivo.setTipoArchivo("PDF");
        archivo.setUrl("/archivos/documento.pdf");
        archivo.setFechaSubida(LocalDateTime.now());
        archivo.setExpedienteId(1);
    }

    @Test
    void testGuardarArchivo() {
        // Given
        when(archivoRepository.save(any(Archivo.class))).thenReturn(archivo);

        // When
        Archivo resultado = archivoService.guardar(archivo);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getNombreArchivo()).isEqualTo("documento.pdf");
        assertThat(resultado.getTipoArchivo()).isEqualTo("PDF");
        verify(archivoRepository).save(archivo);
    }

    @Test
    void testListarArchivos() {
        // Given
        List<Archivo> archivos = Arrays.asList(archivo);
        when(archivoRepository.findAll()).thenReturn(archivos);

        // When
        List<Archivo> resultado = archivoService.listar();

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getNombreArchivo()).isEqualTo("documento.pdf");
        verify(archivoRepository).findAll();
    }
} 