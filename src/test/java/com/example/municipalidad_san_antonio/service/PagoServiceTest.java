package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Pago;
import com.example.municipalidad_san_antonio.repository.PagoRepository;
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
class PagoServiceTest {

    @Mock
    private PagoRepository pagoRepository;

    @InjectMocks
    private PagoService pagoService;

    private Pago pago;

    @BeforeEach
    void setUp() {
        pago = new Pago();
        pago.setIdPago(1);
        pago.setValor(50000);
        pago.setEstadoPago("PENDIENTE");
    }

    @Test
    void testGuardarPago() {
        when(pagoRepository.save(any(Pago.class))).thenReturn(pago);

        Pago resultado = pagoService.save(pago);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getValor()).isEqualTo(50000);
        verify(pagoRepository).save(pago);
    }

    @Test
    void testBuscarPorId() {
        List<Pago> pagos = Arrays.asList(pago);
        when(pagoRepository.findAll()).thenReturn(pagos);

        Pago resultado = pagoService.findAll().get(0);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getIdPago()).isEqualTo(1);
    }
} 