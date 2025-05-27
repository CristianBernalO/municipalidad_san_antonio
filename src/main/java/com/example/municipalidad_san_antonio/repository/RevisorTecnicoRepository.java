package com.example.municipalidad_san_antonio.repository;

import com.example.municipalidad_san_antonio.model.RevisorTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RevisorTecnicoRepository extends JpaRepository<RevisorTecnico, Integer> {
    RevisorTecnico findByEmail(String email);
    RevisorTecnico findById(int idRevisor);
    List<RevisorTecnico> findByNombre(String nombre);

}
