package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.OficinaPartes;
import com.example.municipalidad_san_antonio.service.OficinaPartesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v2/oficina-partes")
public class OficinaPartesController {
    @Autowired
    private OficinaPartesService oficinaPartesService;

    @GetMapping
    public ResponseEntity<List<OficinaPartes>> listar() {
        return ResponseEntity.ok(oficinaPartesService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OficinaPartes> obtenerPorId(@PathVariable Integer id) {
        return oficinaPartesService.listar().stream()
            .filter(o -> o.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OficinaPartes> guardar(@RequestBody OficinaPartes oficinaPartes) {
        return ResponseEntity.ok(oficinaPartesService.guardar(oficinaPartes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OficinaPartes> actualizar(@PathVariable Integer id, @RequestBody OficinaPartes oficinaPartes) {
        oficinaPartes.setId(id);
        return ResponseEntity.ok(oficinaPartesService.guardar(oficinaPartes));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        oficinaPartesService.listar().removeIf(o -> o.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
} 