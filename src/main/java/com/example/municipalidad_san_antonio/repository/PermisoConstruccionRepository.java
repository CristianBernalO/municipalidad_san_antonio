package com.example.municipalidad_san_antonio.repository;

import com.example.municipalidad_san_antonio.model.PermisoConstruccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoConstruccionRepository extends JpaRepository<PermisoConstruccion, Integer> {
}
