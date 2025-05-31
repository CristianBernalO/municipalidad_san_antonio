package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Seguimiento;
import com.example.municipalidad_san_antonio.repository.SeguimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class SeguimientoService {

    @Autowired
    private SeguimientoRepository seguimientoRepository;

    public Optional<Seguimiento> getSeguimiento(Long id) {
        return seguimientoRepository.findById(id);
    }
}
