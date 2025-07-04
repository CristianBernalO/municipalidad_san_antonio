package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.ValidacionDocumental;
import com.example.municipalidad_san_antonio.service.ValidacionDocumentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v2/validaciones-documentales")
public class ValidacionDocumentalController {
    @Autowired
    private ValidacionDocumentalService validacionDocumentalService;

    @GetMapping
    public ResponseEntity<List<ValidacionDocumental>> listar() {
        return ResponseEntity.ok(validacionDocumentalService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValidacionDocumental> obtenerPorId(@PathVariable Integer id) {
        return validacionDocumentalService.listar().stream()
            .filter(v -> v.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ValidacionDocumental> guardar(@RequestBody ValidacionDocumental validacionDocumental) {
        return ResponseEntity.ok(validacionDocumentalService.guardar(validacionDocumental));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ValidacionDocumental> actualizar(@PathVariable Integer id, @RequestBody ValidacionDocumental validacionDocumental) {
        validacionDocumental.setId(id);
        return ResponseEntity.ok(validacionDocumentalService.guardar(validacionDocumental));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        validacionDocumentalService.listar().removeIf(v -> v.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
} 