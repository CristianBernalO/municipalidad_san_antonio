package com.example.municipalidad_san_antonio.repository;

import com.example.municipalidad_san_antonio.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {

    //public Solicitud updateById(Solicitud solicitud);
}
