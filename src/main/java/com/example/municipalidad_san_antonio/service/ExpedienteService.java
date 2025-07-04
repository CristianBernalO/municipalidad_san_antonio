package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Expediente;
import com.example.municipalidad_san_antonio.repository.ExpedienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpedienteService {
    @Autowired
    private ExpedienteRepository expedienteRepository;

    public Expediente guardar(Expediente expediente) {
        return expedienteRepository.save(expediente);
    }

    public List<Expediente> listar() {
        return expedienteRepository.findAll();
    }
} 