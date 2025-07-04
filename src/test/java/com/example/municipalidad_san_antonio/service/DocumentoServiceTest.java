package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Documento;
import com.example.municipalidad_san_antonio.repository.DocumentoRepository;
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
class DocumentoServiceTest {

    @Mock
    private DocumentoRepository documentoRepository;

    @InjectMocks
    private DocumentoService documentoService;

    private Documento documento;

    @BeforeEach
    void setUp() {
        documento = new Documento();
        documento.setIdDocumento(1);
        documento.setTipoDocumento("PLANOS");
        documento.setIdSolicitud(1);
        documento.setArchivoUrl("https://example.com/documento.pdf");
        documento.setFechaSubida(LocalDateTime.now());
    }

    @Test
    void testSaveDocumento() {
        // Given
        when(documentoRepository.save(any(Documento.class))).thenReturn(documento);

        // When
        Documento resultado = documentoService.save(documento);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getTipoDocumento()).isEqualTo("PLANOS");
        verify(documentoRepository).save(documento);
    }

    @Test
    void testFindAll() {
        // Given
        List<Documento> documentos = Arrays.asList(documento);
        when(documentoRepository.findAll()).thenReturn(documentos);

        // When
        List<Documento> resultado = documentoService.findAll();

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getTipoDocumento()).isEqualTo("PLANOS");
        verify(documentoRepository).findAll();
    }

    @Test
    void testFindByIdDocumento() {
        // Given
        List<Documento> documentos = Arrays.asList(documento);
        when(documentoRepository.findByIdDocumento(1)).thenReturn(documentos);

        // When
        List<Documento> resultado = documentoService.findByIdDocumento(1);

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getIdDocumento()).isEqualTo(1);
        verify(documentoRepository).findByIdDocumento(1);
    }

    @Test
    void testFindByIdSolicitud() {
        // Given
        List<Documento> documentos = Arrays.asList(documento);
        when(documentoRepository.findByIdSolicitud(1)).thenReturn(documentos);

        // When
        List<Documento> resultado = documentoService.findByIdSolicitud(1);

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getIdSolicitud()).isEqualTo(1);
        verify(documentoRepository).findByIdSolicitud(1);
    }

    @Test
    void testFindByTipoDocumento() {
        // Given
        List<Documento> documentos = Arrays.asList(documento);
        when(documentoRepository.findByTipoDocumento("PLANOS")).thenReturn(documentos);

        // When
        List<Documento> resultado = documentoService.findByTipoDocumento("PLANOS");

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getTipoDocumento()).isEqualTo("PLANOS");
        verify(documentoRepository).findByTipoDocumento("PLANOS");
    }

    @Test
    void testDelete() {
        // Given
        doNothing().when(documentoRepository).deleteById(1);

        // When
        documentoService.delete(1);

        // Then
        verify(documentoRepository).deleteById(1);
    }
} 