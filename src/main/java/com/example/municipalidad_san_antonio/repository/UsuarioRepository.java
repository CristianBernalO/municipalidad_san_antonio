package com.example.municipalidad_san_antonio.repository;

import com.example.municipalidad_san_antonio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
} 