package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.IntegracionMinvu;
import com.example.municipalidad_san_antonio.repository.IntegracionMinvuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegracionMinvuService {
    @Autowired
    private IntegracionMinvuRepository integracionMinvuRepository;

    public List<IntegracionMinvu> listar() {
        return integracionMinvuRepository.findAll();
    }

    public IntegracionMinvu guardar(IntegracionMinvu integracionMinvu) {
        return integracionMinvuRepository.save(integracionMinvu);
    }

    public IntegracionMinvu findById(Integer id) {
        return integracionMinvuRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) {
        integracionMinvuRepository.deleteById(id);
    }

    public List<IntegracionMinvu> findByEstadoEnvio(String estadoEnvio) {
        return integracionMinvuRepository.findByEstadoEnvio(estadoEnvio);
    }

    public List<IntegracionMinvu> findByExpedienteId(Integer expedienteId) {
        return integracionMinvuRepository.findByExpedienteId(expedienteId);
    }
} 