package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.RevisorTecnico;
import com.example.municipalidad_san_antonio.repository.RevisorTecnicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RevisorTecnicoService {

    @Autowired
    private RevisorTecnicoRepository revisorTecnicoRepository;

    //Traer todos los revisores
    public List<RevisorTecnico> findAll() {
        return revisorTecnicoRepository.findAll();
    }
    // traer por id
    public RevisorTecnico findById(int idRevisor) {
        return revisorTecnicoRepository.findById(idRevisor);
    }

    // Borrar por id
    public void delete(Integer idRevisor) {
        revisorTecnicoRepository.deleteById(idRevisor);
    }
    //Traer por nombre
    public List<RevisorTecnico> findByNombre(String nombre) {
        return revisorTecnicoRepository.findByNombre(nombre);
    }
    //Traer por correo
    public RevisorTecnico findByEmail(String email) {
        return revisorTecnicoRepository.findByEmail(email);
    }
    //Guardar un Revisor
    public RevisorTecnico save(RevisorTecnico revisorTecnico) {
        return revisorTecnicoRepository.save(revisorTecnico);
    }
}
