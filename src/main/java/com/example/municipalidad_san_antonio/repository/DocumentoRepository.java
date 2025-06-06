package com.example.municipalidad_san_antonio.repository;

import com.example.municipalidad_san_antonio.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

    List<Documento> findByIdSolicitud(Integer idSolicitud);
    List<Documento> findByIdDocumento(Integer idDocumento);
    List<Documento> findByTipoDocumento(String tipoDocumento);
}
