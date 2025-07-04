package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.HistorialCambios;
import com.example.municipalidad_san_antonio.service.HistorialCambiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v2/historial-cambios")
public class HistorialCambiosController {
    @Autowired
    private HistorialCambiosService historialCambiosService;

    @GetMapping
    public ResponseEntity<List<HistorialCambios>> listar() {
        return ResponseEntity.ok(historialCambiosService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialCambios> obtenerPorId(@PathVariable Integer id) {
        return historialCambiosService.listar().stream()
            .filter(h -> h.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HistorialCambios> guardar(@RequestBody HistorialCambios historialCambios) {
        return ResponseEntity.ok(historialCambiosService.guardar(historialCambios));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialCambios> actualizar(@PathVariable Integer id, @RequestBody HistorialCambios historialCambios) {
        historialCambios.setId(id);
        return ResponseEntity.ok(historialCambiosService.guardar(historialCambios));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        historialCambiosService.listar().removeIf(h -> h.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
} 