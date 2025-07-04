package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.ValidacionDocumental;
import com.example.municipalidad_san_antonio.repository.ValidacionDocumentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidacionDocumentalService {
    @Autowired
    private ValidacionDocumentalRepository validacionDocumentalRepository;

    public ValidacionDocumental guardar(ValidacionDocumental validacionDocumental) {
        return validacionDocumentalRepository.save(validacionDocumental);
    }

    public List<ValidacionDocumental> listar() {
        return validacionDocumentalRepository.findAll();
    }
} 