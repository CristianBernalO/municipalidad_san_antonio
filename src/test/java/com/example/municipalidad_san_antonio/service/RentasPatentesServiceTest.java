package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.RentasPatentes;
import com.example.municipalidad_san_antonio.repository.RentasPatentesRepository;
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
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RentasPatentesServiceTest {

    @Mock
    private RentasPatentesRepository rentasPatentesRepository;

    @InjectMocks
    private RentasPatentesService rentasPatentesService;

    private RentasPatentes rentasPatentes;

    @BeforeEach
    void setUp() {
        rentasPatentes = new RentasPatentes();
        rentasPatentes.setId(1);
        rentasPatentes.setSolicitudId(1);
        rentasPatentes.setMonto(50000.0);
        rentasPatentes.setEstado("PENDIENTE");
    }

    @Test
    void testGuardarRentasPatentes() {
        // Given
        when(rentasPatentesRepository.save(any(RentasPatentes.class))).thenReturn(rentasPatentes);

        // When
        RentasPatentes resultado = rentasPatentesService.guardar(rentasPatentes);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getMonto()).isEqualTo(50000.0);
        assertThat(resultado.getEstado()).isEqualTo("PENDIENTE");
        assertThat(resultado.getSolicitudId()).isEqualTo(1);
        verify(rentasPatentesRepository).save(rentasPatentes);
    }

    @Test
    void testListarRentasPatentes() {
        // Given
        List<RentasPatentes> rentas = Arrays.asList(rentasPatentes);
        when(rentasPatentesRepository.findAll()).thenReturn(rentas);

        // When
        List<RentasPatentes> resultado = rentasPatentesService.listar();

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getMonto()).isEqualTo(50000.0);
        assertThat(resultado.get(0).getSolicitudId()).isEqualTo(1);
        verify(rentasPatentesRepository).findAll();
    }

    @Test
    void testListarRentasPatentesVacio() {
        // Given
        when(rentasPatentesRepository.findAll()).thenReturn(Arrays.asList());

        // When
        List<RentasPatentes> resultado = rentasPatentesService.listar();

        // Then
        assertThat(resultado).isEmpty();
        verify(rentasPatentesRepository).findAll();
    }

    @Test
    void testGuardarRentasPatentesConDatosNulos() {
        // Given
        RentasPatentes rentasNulas = new RentasPatentes();
        when(rentasPatentesRepository.save(any(RentasPatentes.class))).thenReturn(rentasNulas);

        // When
        RentasPatentes resultado = rentasPatentesService.guardar(rentasNulas);

        // Then
        assertThat(resultado).isNotNull();
        verify(rentasPatentesRepository).save(rentasNulas);
    }
} 