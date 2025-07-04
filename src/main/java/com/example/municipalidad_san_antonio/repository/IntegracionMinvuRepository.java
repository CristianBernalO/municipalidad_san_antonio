package com.example.municipalidad_san_antonio.repository;

import com.example.municipalidad_san_antonio.model.IntegracionMinvu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntegracionMinvuRepository extends JpaRepository<IntegracionMinvu, Integer> {
    
    List<IntegracionMinvu> findByEstadoEnvio(String estadoEnvio);
    
    List<IntegracionMinvu> findByExpedienteId(Integer expedienteId);
} 