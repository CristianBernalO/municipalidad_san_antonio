package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.Resolucion;
import com.example.municipalidad_san_antonio.service.ResolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v2/resoluciones")
public class ResolucionController {
    @Autowired
    private ResolucionService resolucionService;

    @GetMapping
    public ResponseEntity<List<Resolucion>> listar() {
        return ResponseEntity.ok(resolucionService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resolucion> obtenerPorId(@PathVariable Integer id) {
        return resolucionService.listar().stream()
            .filter(r -> r.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Resolucion> guardar(@RequestBody Resolucion resolucion) {
        return ResponseEntity.ok(resolucionService.guardar(resolucion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resolucion> actualizar(@PathVariable Integer id, @RequestBody Resolucion resolucion) {
        resolucion.setId(id);
        return ResponseEntity.ok(resolucionService.guardar(resolucion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        resolucionService.listar().removeIf(r -> r.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
} 