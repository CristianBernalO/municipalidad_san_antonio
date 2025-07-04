package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Observacion;
import com.example.municipalidad_san_antonio.repository.ObservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservacionService {
    @Autowired
    private ObservacionRepository observacionRepository;

    public Observacion guardar(Observacion observacion) {
        return observacionRepository.save(observacion);
    }

    public List<Observacion> listar() {
        return observacionRepository.findAll();
    }
} 