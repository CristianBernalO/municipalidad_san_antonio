package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.ReporteAuditoria;
import com.example.municipalidad_san_antonio.service.ReporteAuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v2/reportes-auditoria")
public class ReporteAuditoriaController {
    @Autowired
    private ReporteAuditoriaService reporteAuditoriaService;

    @GetMapping
    public ResponseEntity<List<ReporteAuditoria>> listar() {
        return ResponseEntity.ok(reporteAuditoriaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteAuditoria> obtenerPorId(@PathVariable Integer id) {
        return reporteAuditoriaService.listar().stream()
            .filter(r -> r.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReporteAuditoria> guardar(@RequestBody ReporteAuditoria reporteAuditoria) {
        return ResponseEntity.ok(reporteAuditoriaService.guardar(reporteAuditoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReporteAuditoria> actualizar(@PathVariable Integer id, @RequestBody ReporteAuditoria reporteAuditoria) {
        reporteAuditoria.setId(id);
        return ResponseEntity.ok(reporteAuditoriaService.guardar(reporteAuditoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        reporteAuditoriaService.listar().removeIf(r -> r.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
} 