package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Solicitud;
import com.example.municipalidad_san_antonio.repository.SolicitudRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;
    //Eliminar por ID
    public void deleteSolicitud(Integer id) { this.solicitudRepository.deleteById(id); }
    //Traer una solicitud por ID
    public Solicitud findById(Integer id) { return solicitudRepository.findById(id).orElse(null); }
    //Traer todas las solicitudes
    public List<Solicitud> findAll() { return solicitudRepository.findAll(); }
    //Guardar una solicitud
    public Solicitud save(Solicitud solicitud) { return solicitudRepository.save(solicitud); }
    //actualizar solicitud por id
    public String actualizarSolicitud(Integer id, Solicitud solicitud) {
        Solicitud solicitudActual = solicitudRepository.findById(id).orElse(null);
        if (solicitudActual == null) {
            return "Solicitud no encontrada";
        }
        solicitudActual = solicitud;
        solicitudRepository.save(solicitudActual);
        return "Solicitud actualizada";
    }
    public List<Solicitud> findAllByEstadoSolicitud(String estadoSolicitud) {
        return solicitudRepository.findByEstadoSolicitud(estadoSolicitud);
    }
}
