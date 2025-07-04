package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Usuario;
import com.example.municipalidad_san_antonio.repository.UsuarioRepository;
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
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

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
    void testGuardarUsuario() {
        // Given
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        // When
        Usuario resultado = usuarioService.guardar(usuario);

        // Then
        assertThat(resultado).isNotNull();
        assertThat(resultado.getNombre()).isEqualTo("Juan Pérez");
        assertThat(resultado.getEmail()).isEqualTo("juan@test.com");
        verify(usuarioRepository).save(usuario);
    }

    @Test
    void testListarUsuarios() {
        // Given
        List<Usuario> usuarios = Arrays.asList(usuario);
        when(usuarioRepository.findAll()).thenReturn(usuarios);

        // When
        List<Usuario> resultado = usuarioService.listar();

        // Then
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getNombre()).isEqualTo("Juan Pérez");
        verify(usuarioRepository).findAll();
    }
} 