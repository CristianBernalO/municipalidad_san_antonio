package com.example.municipalidad_san_antonio.repository;

import com.example.municipalidad_san_antonio.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {

    List<Solicitud> findByEstadoSolicitud(String estadoSolicitud);
}
