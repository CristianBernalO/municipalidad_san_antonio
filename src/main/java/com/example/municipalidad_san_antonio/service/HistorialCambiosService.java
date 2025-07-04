package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.HistorialCambios;
import com.example.municipalidad_san_antonio.repository.HistorialCambiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialCambiosService {
    @Autowired
    private HistorialCambiosRepository historialCambiosRepository;

    public HistorialCambios guardar(HistorialCambios historialCambios) {
        return historialCambiosRepository.save(historialCambios);
    }

    public List<HistorialCambios> listar() {
        return historialCambiosRepository.findAll();
    }
} 