package com.example.municipalidad_san_antonio.repository;

import com.example.municipalidad_san_antonio.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {}
