package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.OficinaPartes;
import com.example.municipalidad_san_antonio.repository.OficinaPartesRepository;
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
class OficinaPartesServiceTest {

    @Mock
    private OficinaPartesRepository oficinaPartesRepository;

    @InjectMocks
    private OficinaPartesService oficinaPartesService;

    private OficinaPartes oficinaPartes;

    @BeforeEach
    void setUp() {
        oficinaPartes = new OficinaPartes();
        oficinaPartes.setId(1);
        oficinaPartes.setExpedienteId(1);
        oficinaPartes.setFechaIngreso(LocalDateTime.now());
        oficinaPartes.setEstadoDistribucion("PENDIENTE");
    }

    @Test
    void testGuardarOficinaPartes() {
        // Given
        when(oficinaPartesRepository.save(any(OficinaPartes.class))).thenReturn(oficinaPartes);

        // When
        OficinaPartes resultado = oficinaPartesService.guardar(oficinaPartes);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getEstadoDistribucion()).isEqualTo("PENDIENTE");
        assertThat(resultado.getExpedienteId()).isEqualTo(1);
        verify(oficinaPartesRepository).save(oficinaPartes);
    }

    @Test
    void testListarOficinaPartes() {
        // Given
        List<OficinaPartes> oficinas = Arrays.asList(oficinaPartes);
        when(oficinaPartesRepository.findAll()).thenReturn(oficinas);

        // When
        List<OficinaPartes> resultado = oficinaPartesService.listar();

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getEstadoDistribucion()).isEqualTo("PENDIENTE");
        verify(oficinaPartesRepository).findAll();
    }
}