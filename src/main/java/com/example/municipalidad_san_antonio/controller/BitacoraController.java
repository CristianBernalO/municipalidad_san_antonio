package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.Bitacora;
import com.example.municipalidad_san_antonio.service.BitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v2/bitacoras")
public class BitacoraController {
    @Autowired
    private BitacoraService bitacoraService;

    @GetMapping
    public ResponseEntity<List<Bitacora>> listar() {
        return ResponseEntity.ok(bitacoraService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bitacora> obtenerPorId(@PathVariable Integer id) {
        return bitacoraService.listar().stream()
            .filter(b -> b.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Bitacora> guardar(@RequestBody Bitacora bitacora) {
        return ResponseEntity.ok(bitacoraService.guardar(bitacora));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bitacora> actualizar(@PathVariable Integer id, @RequestBody Bitacora bitacora) {
        bitacora.setId(id);
        return ResponseEntity.ok(bitacoraService.guardar(bitacora));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        bitacoraService.listar().removeIf(b -> b.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
} 