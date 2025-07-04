package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.Expediente;
import com.example.municipalidad_san_antonio.service.ExpedienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v2/expedientes")
public class ExpedienteController {
    @Autowired
    private ExpedienteService expedienteService;

    @GetMapping
    public ResponseEntity<List<Expediente>> listar() {
        return ResponseEntity.ok(expedienteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expediente> obtenerPorId(@PathVariable Integer id) {
        return expedienteService.listar().stream()
            .filter(e -> e.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Expediente> guardar(@RequestBody Expediente expediente) {
        return ResponseEntity.ok(expedienteService.guardar(expediente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expediente> actualizar(@PathVariable Integer id, @RequestBody Expediente expediente) {
        expediente.setId(id);
        return ResponseEntity.ok(expedienteService.guardar(expediente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        expedienteService.listar().removeIf(e -> e.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
} 