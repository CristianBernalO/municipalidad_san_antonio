package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.PermisoConstruccion;
import com.example.municipalidad_san_antonio.repository.PermisoConstruccionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PermisoConstruccionService {

    @Autowired
    private PermisoConstruccionRepository permisoConstruccionRepository;

    //traer por id
    public PermisoConstruccion findById(Integer id) {
        return permisoConstruccionRepository.findById(id).orElse(null);
    }

    //Traer todos los permisos
    public List<PermisoConstruccion> findAll() {
        return permisoConstruccionRepository.findAll();
    }

    // Guardar un permiso
    public PermisoConstruccion save(PermisoConstruccion permiso) {
        return permisoConstruccionRepository.save(permiso);
    }

    // Eliminar por ID
    public void deleteById(Integer id) {
        permisoConstruccionRepository.deleteById(id);
    }

    // Buscar por tipo de permiso
    public List<PermisoConstruccion> findByTipoPermiso(String tipoPermiso) {
        return permisoConstruccionRepository.findByTipoPermiso(tipoPermiso);
    }

    // Buscar por nombre del solicitante
    public List<PermisoConstruccion> findByNombreSolicitante(String nombreSolicitante) {
        return permisoConstruccionRepository.findByNombreSolicitante(nombreSolicitante);
    }
}
