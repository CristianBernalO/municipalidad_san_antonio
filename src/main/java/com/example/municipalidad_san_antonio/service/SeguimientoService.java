package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Seguimiento;
import com.example.municipalidad_san_antonio.model.Solicitud;
import com.example.municipalidad_san_antonio.repository.SeguimientoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SeguimientoService {
    
    @Autowired
    private SolicitudService solicitudService;
    
    @Autowired
    private SeguimientoRepository seguimientoRepository;

    public Seguimiento getSeguimiento(Integer id) {
        Solicitud sol = solicitudService.findById(id);
        Seguimiento seguimiento = new Seguimiento();
        if (sol != null) {
            seguimiento.setId(sol.getIdSolicitud());
            seguimiento.setEstado(sol.getEstadoSolicitud());
            seguimiento.setMensaje(sol.getObservacionSolicitud());
        }
        return seguimiento;
    }

    // Obtener todos los seguimientos
    public List<Seguimiento> findAll() {
        return seguimientoRepository.findAll();
    }

    // Obtener seguimiento por ID
    public Seguimiento findById(Integer id) {
        return seguimientoRepository.findById(id).orElse(null);
    }

    // Guardar un seguimiento
    public Seguimiento save(Seguimiento seguimiento) {
        return seguimientoRepository.save(seguimiento);
    }

    // Eliminar por ID
    public void deleteById(Integer id) {
        seguimientoRepository.deleteById(id);
    }

    // Buscar por estado
    public List<Seguimiento> findByEstado(String estado) {
        return seguimientoRepository.findByEstado(estado);
    }
}
