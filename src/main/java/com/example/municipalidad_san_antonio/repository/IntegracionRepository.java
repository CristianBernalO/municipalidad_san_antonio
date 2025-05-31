package com.example.municipalidad_san_antonio.repository;

import com.example.municipalidad_san_antonio.model.Integracion;
import com.example.municipalidad_san_antonio.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntegracionRepository extends JpaRepository<Integracion, Long> {
    static Integracion save(Solicitud solicitud) {
    }
}
