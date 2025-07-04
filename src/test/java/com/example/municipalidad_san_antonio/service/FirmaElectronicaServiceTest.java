package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.FirmaElectronica;
import com.example.municipalidad_san_antonio.repository.FirmaElectronicaRepository;
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
class FirmaElectronicaServiceTest {

    @Mock
    private FirmaElectronicaRepository firmaElectronicaRepository;

    @InjectMocks
    private FirmaElectronicaService firmaElectronicaService;

    private FirmaElectronica firmaElectronica;

    @BeforeEach
    void setUp() {
        firmaElectronica = new FirmaElectronica();
        firmaElectronica.setId(1);
        firmaElectronica.setDocumentoId(100);
        firmaElectronica.setFirmante("Juan Pérez");
        firmaElectronica.setFechaFirma(LocalDateTime.now());
        firmaElectronica.setTipoFirma("AVANZADA");
    }

    @Test
    void testGuardarFirmaElectronica() {
        // Given
        when(firmaElectronicaRepository.save(any(FirmaElectronica.class))).thenReturn(firmaElectronica);

        // When
        FirmaElectronica resultado = firmaElectronicaService.guardar(firmaElectronica);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getTipoFirma()).isEqualTo("AVANZADA");
        assertThat(resultado.getFirmante()).isEqualTo("Juan Pérez");
        verify(firmaElectronicaRepository).save(firmaElectronica);
    }

    @Test
    void testListarFirmasElectronicas() {
        // Given
        List<FirmaElectronica> firmas = Arrays.asList(firmaElectronica);
        when(firmaElectronicaRepository.findAll()).thenReturn(firmas);

        // When
        List<FirmaElectronica> resultado = firmaElectronicaService.listar();

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getTipoFirma()).isEqualTo("AVANZADA");
        assertThat(resultado.get(0).getFirmante()).isEqualTo("Juan Pérez");
        verify(firmaElectronicaRepository).findAll();
    }

    @Test
    void testGuardarFirmaElectronicaConDatosNulos() {
        // Given
        FirmaElectronica firmaNula = new FirmaElectronica();
        when(firmaElectronicaRepository.save(any(FirmaElectronica.class))).thenReturn(firmaNula);

        // When
        FirmaElectronica resultado = firmaElectronicaService.guardar(firmaNula);

        // Then
        assertThat(resultado).isNotNull();
        verify(firmaElectronicaRepository).save(firmaNula);
    }

    @Test
    void testListarFirmasElectronicasVacia() {
        // Given
        when(firmaElectronicaRepository.findAll()).thenReturn(Arrays.asList());

        // When
        List<FirmaElectronica> resultado = firmaElectronicaService.listar();

        // Then
        assertThat(resultado).isEmpty();
        verify(firmaElectronicaRepository).findAll();
    }
} 