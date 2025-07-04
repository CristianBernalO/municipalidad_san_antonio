package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Archivo;
import com.example.municipalidad_san_antonio.repository.ArchivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchivoService {
    @Autowired
    private ArchivoRepository archivoRepository;

    public Archivo guardar(Archivo archivo) {
        return archivoRepository.save(archivo);
    }

    public List<Archivo> listar() {
        return archivoRepository.findAll();
    }
} 