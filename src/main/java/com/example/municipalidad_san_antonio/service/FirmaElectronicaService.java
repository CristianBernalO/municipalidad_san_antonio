package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.FirmaElectronica;
import com.example.municipalidad_san_antonio.repository.FirmaElectronicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirmaElectronicaService {
    @Autowired
    private FirmaElectronicaRepository firmaElectronicaRepository;

    public FirmaElectronica guardar(FirmaElectronica firmaElectronica) {
        return firmaElectronicaRepository.save(firmaElectronica);
    }

    public List<FirmaElectronica> listar() {
        return firmaElectronicaRepository.findAll();
    }
} 