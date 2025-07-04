package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.FirmaElectronica;
import com.example.municipalidad_san_antonio.service.FirmaElectronicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v2/firmas-electronicas")
public class FirmaElectronicaController {
    @Autowired
    private FirmaElectronicaService firmaElectronicaService;

    @GetMapping
    public ResponseEntity<List<FirmaElectronica>> listar() {
        return ResponseEntity.ok(firmaElectronicaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FirmaElectronica> obtenerPorId(@PathVariable Integer id) {
        return firmaElectronicaService.listar().stream()
            .filter(f -> f.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FirmaElectronica> guardar(@RequestBody FirmaElectronica firmaElectronica) {
        return ResponseEntity.ok(firmaElectronicaService.guardar(firmaElectronica));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FirmaElectronica> actualizar(@PathVariable Integer id, @RequestBody FirmaElectronica firmaElectronica) {
        firmaElectronica.setId(id);
        return ResponseEntity.ok(firmaElectronicaService.guardar(firmaElectronica));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        firmaElectronicaService.listar().removeIf(f -> f.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
} 