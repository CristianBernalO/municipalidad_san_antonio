package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.Usuario;
import com.example.municipalidad_san_antonio.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @Autowired
    private ObjectMapper objectMapper;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();
        usuario.setId(1);
        usuario.setNombre("Juan Pérez");
        usuario.setEmail("juan@test.com");
        usuario.setPassword("password123");
        usuario.setRol("CIUDADANO");
        usuario.setActivo(true);
    }

    @Test
    void testCrearUsuario() throws Exception {
        // Given
        when(usuarioService.guardar(any(Usuario.class))).thenReturn(usuario);

        // When & Then
        mockMvc.perform(post("/api/v2/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre").value("Juan Pérez"))
                .andExpect(jsonPath("$.email").value("juan@test.com"));
    }

    @Test
    void testListarUsuarios() throws Exception {
        // Given
        List<Usuario> usuarios = Arrays.asList(usuario);
        when(usuarioService.listar()).thenReturn(usuarios);

        // When & Then
        mockMvc.perform(get("/api/v2/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].nombre").value("Juan Pérez"));
    }
} 