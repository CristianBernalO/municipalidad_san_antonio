package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.ReporteAuditoria;
import com.example.municipalidad_san_antonio.repository.ReporteAuditoriaRepository;
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
class ReporteAuditoriaServiceTest {

    @Mock
    private ReporteAuditoriaRepository reporteAuditoriaRepository;

    @InjectMocks
    private ReporteAuditoriaService reporteAuditoriaService;

    private ReporteAuditoria reporteAuditoria;

    @BeforeEach
    void setUp() {
        reporteAuditoria = new ReporteAuditoria();
        reporteAuditoria.setId(1);
        reporteAuditoria.setTipoReporte("AUDITORIA_SOLICITUDES");
        reporteAuditoria.setFechaGeneracion(LocalDateTime.now());
        reporteAuditoria.setGeneradoPor("admin@municipalidad.cl");
        reporteAuditoria.setDescripcion("Reporte de auditoría de solicitudes del sistema");
    }

    @Test
    void testGuardarReporteAuditoria() {
        // Given
        when(reporteAuditoriaRepository.save(any(ReporteAuditoria.class))).thenReturn(reporteAuditoria);

        // When
        ReporteAuditoria resultado = reporteAuditoriaService.guardar(reporteAuditoria);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getTipoReporte()).isEqualTo("AUDITORIA_SOLICITUDES");
        assertThat(resultado.getGeneradoPor()).isEqualTo("admin@municipalidad.cl");
        verify(reporteAuditoriaRepository).save(reporteAuditoria);
    }

    @Test
    void testListarReportesAuditoria() {
        // Given
        List<ReporteAuditoria> reportes = Arrays.asList(reporteAuditoria);
        when(reporteAuditoriaRepository.findAll()).thenReturn(reportes);

        // When
        List<ReporteAuditoria> resultado = reporteAuditoriaService.listar();

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getTipoReporte()).isEqualTo("AUDITORIA_SOLICITUDES");
        verify(reporteAuditoriaRepository).findAll();
    }
} 