package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.OficinaPartes;
import com.example.municipalidad_san_antonio.repository.OficinaPartesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OficinaPartesService {
    @Autowired
    private OficinaPartesRepository oficinaPartesRepository;

    public OficinaPartes guardar(OficinaPartes oficinaPartes) {
        return oficinaPartesRepository.save(oficinaPartes);
    }

    public List<OficinaPartes> listar() {
        return oficinaPartesRepository.findAll();
    }
} 