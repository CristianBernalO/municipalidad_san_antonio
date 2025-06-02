package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Seguimiento;
import com.example.municipalidad_san_antonio.model.Solicitud;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class SeguimientoService {
    Seguimiento seguimiento;
    @Autowired
    SolicitudService solicitudService;

    public Seguimiento getSeguimiento(Integer id) {
        Solicitud sol =solicitudService.findById(id);
        seguimiento.setId(sol.getIdSolicitud());
        seguimiento.setEstado(sol.getEstadoSolicitud());
        seguimiento.setMensaje(sol.getObservacionSolicitud());
        return seguimiento;
    }
}
