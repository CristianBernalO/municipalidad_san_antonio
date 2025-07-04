package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.RentasPatentes;
import com.example.municipalidad_san_antonio.service.RentasPatentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v2/rentas-patentes")
public class RentasPatentesController {
    @Autowired
    private RentasPatentesService rentasPatentesService;

    @GetMapping
    public ResponseEntity<List<RentasPatentes>> listar() {
        return ResponseEntity.ok(rentasPatentesService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentasPatentes> obtenerPorId(@PathVariable Integer id) {
        return rentasPatentesService.listar().stream()
            .filter(r -> r.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RentasPatentes> guardar(@RequestBody RentasPatentes rentasPatentes) {
        return ResponseEntity.ok(rentasPatentesService.guardar(rentasPatentes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentasPatentes> actualizar(@PathVariable Integer id, @RequestBody RentasPatentes rentasPatentes) {
        rentasPatentes.setId(id);
        return ResponseEntity.ok(rentasPatentesService.guardar(rentasPatentes));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        rentasPatentesService.listar().removeIf(r -> r.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
} 