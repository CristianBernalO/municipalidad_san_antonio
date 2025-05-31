package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Integracion;
import com.example.municipalidad_san_antonio.model.Solicitud;
import com.example.municipalidad_san_antonio.repository.IntegracionRepository;

import java.util.Optional;

public class IntegracionService {


    private IntegracionRepository integracionRepository;

    public static Integracion saveSolicitud(Solicitud solicitud) {
        solicitud.setEstadoSolicitud("Pendiente");
        return IntegracionRepository.save(solicitud);
    }

    public Integracion sendSolicitud(Solicitud solicitud) {
        solicitud.setEstadoSolicitud("Enviado");
        solicitud.setObservacionSolicitud("Expendiente enviado a minvu");
        return IntegracionRepository.save(solicitud);
    }

    public static Optional<Integracion> getEstado(Long id) {
        return IntegracionRepository.findById(id);
    }
}
