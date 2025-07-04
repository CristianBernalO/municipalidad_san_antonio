package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.Observacion;
import com.example.municipalidad_san_antonio.service.ObservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v2/observaciones")
public class ObservacionController {
    @Autowired
    private ObservacionService observacionService;

    @GetMapping
    public ResponseEntity<List<Observacion>> listar() {
        return ResponseEntity.ok(observacionService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Observacion> obtenerPorId(@PathVariable Integer id) {
        return observacionService.listar().stream()
            .filter(o -> o.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Observacion> guardar(@RequestBody Observacion observacion) {
        return ResponseEntity.ok(observacionService.guardar(observacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Observacion> actualizar(@PathVariable Integer id, @RequestBody Observacion observacion) {
        observacion.setId(id);
        return ResponseEntity.ok(observacionService.guardar(observacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        observacionService.listar().removeIf(o -> o.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
} 