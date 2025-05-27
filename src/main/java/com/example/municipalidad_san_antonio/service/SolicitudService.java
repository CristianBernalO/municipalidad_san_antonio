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
    //public Solicitud updateById(Solicitud solicitud) {
    //    solicitud.getIdSolicitud();
    //    return}
    //Eliminar por ID
    public void deleteSolicitud(Integer id) { this.solicitudRepository.deleteById(id); }
    //Traer una solicitud por ID
    public Solicitud findById(Integer id) { return solicitudRepository.findById(id).orElse(null); }
    //Traer todas las solicitudes
    public List<Solicitud> findAll() { return solicitudRepository.findAll(); }
    //Guardar una solicitud
    public Solicitud save(Solicitud solicitud) { return solicitudRepository.save(solicitud); }
}
