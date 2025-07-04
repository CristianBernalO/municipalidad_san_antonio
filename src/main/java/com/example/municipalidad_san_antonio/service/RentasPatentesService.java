package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.RentasPatentes;
import com.example.municipalidad_san_antonio.repository.RentasPatentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentasPatentesService {
    @Autowired
    private RentasPatentesRepository rentasPatentesRepository;

    public RentasPatentes guardar(RentasPatentes rentasPatentes) {
        return rentasPatentesRepository.save(rentasPatentes);
    }

    public List<RentasPatentes> listar() {
        return rentasPatentesRepository.findAll();
    }
} 