package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.service.SeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class SeguimientoController {

    @Autowired
    private SeguimientoService seguimientoService;

    @GetMapping
    public ResponseEntity<?> getSeguimiento(@PathVariable Long id) {
        return seguimientoService.getSeguimiento(id).
                map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());
    }
}
