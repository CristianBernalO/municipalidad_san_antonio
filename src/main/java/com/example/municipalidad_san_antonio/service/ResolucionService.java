package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Resolucion;
import com.example.municipalidad_san_antonio.repository.ResolucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResolucionService {
    @Autowired
    private ResolucionRepository resolucionRepository;

    public Resolucion guardar(Resolucion resolucion) {
        return resolucionRepository.save(resolucion);
    }

    public List<Resolucion> listar() {
        return resolucionRepository.findAll();
    }
} 