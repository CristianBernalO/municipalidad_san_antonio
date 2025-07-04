package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.PermisoConstruccion;
import com.example.municipalidad_san_antonio.repository.PermisoConstruccionRepository;
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
class PermisoConstruccionServiceTest {

    @Mock
    private PermisoConstruccionRepository permisoConstruccionRepository;

    @InjectMocks
    private PermisoConstruccionService permisoConstruccionService;

    private PermisoConstruccion permisoConstruccion;

    @BeforeEach
    void setUp() {
        permisoConstruccion = new PermisoConstruccion();
        permisoConstruccion.setIdPermiso(1);
        permisoConstruccion.setIdSolicitud(1);
        permisoConstruccion.setCodigoPermiso("PC-2024-001");
        permisoConstruccion.setNombreSolicitante("Juan Pérez");
        permisoConstruccion.setTipoPermiso("Construcción Residencial");
        permisoConstruccion.setFirmaAutorizante("Ing. María González");
    }

    @Test
    void testFindById() {
        // Given
        when(permisoConstruccionRepository.findById(1)).thenReturn(Optional.of(permisoConstruccion));

        // When
        PermisoConstruccion resultado = permisoConstruccionService.findById(1);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getCodigoPermiso()).isEqualTo("PC-2024-001");
        assertThat(resultado.getNombreSolicitante()).isEqualTo("Juan Pérez");
        verify(permisoConstruccionRepository).findById(1);
    }

    @Test
    void testFindAll() {
        // Given
        List<PermisoConstruccion> permisos = Arrays.asList(permisoConstruccion);
        when(permisoConstruccionRepository.findAll()).thenReturn(permisos);

        // When
        List<PermisoConstruccion> resultado = permisoConstruccionService.findAll();

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getCodigoPermiso()).isEqualTo("PC-2024-001");
        verify(permisoConstruccionRepository).findAll();
    }

    @Test
    void testFindByIdNotFound() {
        // Given
        when(permisoConstruccionRepository.findById(999)).thenReturn(Optional.empty());

        // When
        PermisoConstruccion resultado = permisoConstruccionService.findById(999);

        // Then
        assertThat(resultado).isNull();
        verify(permisoConstruccionRepository).findById(999);
    }
} 