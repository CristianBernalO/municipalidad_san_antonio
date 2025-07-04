package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.Solicitud;
import com.example.municipalidad_san_antonio.service.DocumentoService;
import com.example.municipalidad_san_antonio.service.PermisoConstruccionService;
import com.example.municipalidad_san_antonio.service.SeguimientoService;
import com.example.municipalidad_san_antonio.service.SolicitudService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SolicitudController.class)
@ActiveProfiles("test")
class SolicitudControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SolicitudService solicitudService;

    @MockBean
    private DocumentoService documentoService;

    @MockBean
    private PermisoConstruccionService permisoConstruccionService;

    @MockBean
    private SeguimientoService seguimientoService;

    @Autowired
    private ObjectMapper objectMapper;

    private Solicitud solicitud;

    @BeforeEach
    void setUp() {
        solicitud = new Solicitud();
        solicitud.setIdSolicitud(1);
        solicitud.setNombreSolicitante("Juan Pérez");
        solicitud.setRutSolicitante("12345678-9");
        solicitud.setFechaSolicitud(new Date());
        solicitud.setEstadoSolicitud("PENDIENTE");
    }

    @Test
    void testCrearSolicitud() throws Exception {
        // Given
        when(solicitudService.save(any(Solicitud.class))).thenReturn(solicitud);

        // When & Then
        mockMvc.perform(post("/api/v1/solicitudes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(solicitud)))
                .andExpect(status().isCreated())
                .andExpect(content().string("Solicitud guardada"));
    }

    @Test
    void testObtenerSolicitud() throws Exception {
        // Given
        when(solicitudService.findById(1)).thenReturn(solicitud);

        // When & Then
        mockMvc.perform(get("/api/v1/solicitudes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idSolicitud").value(1))
                .andExpect(jsonPath("$.nombreSolicitante").value("Juan Pérez"));
    }

    @Test
    void testListarSolicitudes() throws Exception {
        // Given
        List<Solicitud> solicitudes = Arrays.asList(solicitud);
        when(solicitudService.findAll()).thenReturn(solicitudes);

        // When & Then
        mockMvc.perform(get("/api/v1/solicitudes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].nombreSolicitante").value("Juan Pérez"));
    }

    @Test
    void testActualizarSolicitud() throws Exception {
        // Given
        when(solicitudService.actualizarSolicitud(eq(1), any(Solicitud.class)))
                .thenReturn("Solicitud actualizada");

        // When & Then
        mockMvc.perform(put("/api/v1/solicitudes/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(solicitud)))
                .andExpect(status().isOk())
                .andExpect(content().string("Solicitud actualizada"));
    }

    @Test
    void testEliminarSolicitud() throws Exception {
        // Given
        when(solicitudService.findById(1)).thenReturn(solicitud);

        // When & Then
        mockMvc.perform(delete("/api/v1/borrarsolicitud/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Solicitud eliminada"));
    }

    @Test
    void testBuscarPorEstado() throws Exception {
        // Given
        List<Solicitud> solicitudes = Arrays.asList(solicitud);
        when(solicitudService.findAllByEstadoSolicitud("Pendiente revision tecnica")).thenReturn(solicitudes);

        // When & Then
        mockMvc.perform(get("/api/v1/revisiones/pendientes")
                .param("estadoSolicitud", "Pendiente revision tecnica"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].estadoSolicitud").value("PENDIENTE"));
    }
}