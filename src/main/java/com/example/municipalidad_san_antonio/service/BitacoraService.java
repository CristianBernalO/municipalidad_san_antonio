package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Bitacora;
import com.example.municipalidad_san_antonio.repository.BitacoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BitacoraService {
    @Autowired
    private BitacoraRepository bitacoraRepository;

    public Bitacora guardar(Bitacora bitacora) {
        return bitacoraRepository.save(bitacora);
    }

    public List<Bitacora> listar() {
        return bitacoraRepository.findAll();
    }
} 