package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.Archivo;
import com.example.municipalidad_san_antonio.service.ArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v2/archivos")
public class ArchivoController {
    @Autowired
    private ArchivoService archivoService;

    @GetMapping
    public ResponseEntity<List<Archivo>> listar() {
        return ResponseEntity.ok(archivoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Archivo> obtenerPorId(@PathVariable Integer id) {
        return archivoService.listar().stream()
            .filter(a -> a.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Archivo> guardar(@RequestBody Archivo archivo) {
        return ResponseEntity.ok(archivoService.guardar(archivo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Archivo> actualizar(@PathVariable Integer id, @RequestBody Archivo archivo) {
        archivo.setId(id);
        return ResponseEntity.ok(archivoService.guardar(archivo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        archivoService.listar().removeIf(a -> a.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
} 