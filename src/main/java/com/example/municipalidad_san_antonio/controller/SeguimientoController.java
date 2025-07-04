package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.Seguimiento;
import com.example.municipalidad_san_antonio.service.SeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seguimientos")
public class SeguimientoController {

    @Autowired
    private SeguimientoService seguimientoService;

    /**
     * Obtener el seguimiento de una solicitud por ID
     */
    @GetMapping("/solicitud/{id}")
    public ResponseEntity<Seguimiento> obtenerSeguimientoPorSolicitud(@PathVariable Integer id) {
        Seguimiento seguimiento = seguimientoService.getSeguimiento(id);
        if (seguimiento == null || seguimiento.getId() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seguimiento);
    }

    /**
     * Obtener todos los seguimientos
     */
    @GetMapping
    public ResponseEntity<List<Seguimiento>> obtenerTodosLosSeguimientos() {
        List<Seguimiento> seguimientos = seguimientoService.findAll();
        return ResponseEntity.ok(seguimientos);
    }

    /**
     * Obtener un seguimiento por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Seguimiento> obtenerSeguimientoPorId(@PathVariable Integer id) {
        Seguimiento seguimiento = seguimientoService.findById(id);
        if (seguimiento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seguimiento);
    }

    /**
     * Crear un nuevo seguimiento
     */
    @PostMapping
    public ResponseEntity<Seguimiento> crearSeguimiento(@RequestBody Seguimiento seguimiento) {
        if (seguimiento == null) {
            return ResponseEntity.badRequest().build();
        }
        Seguimiento seguimientoGuardado = seguimientoService.save(seguimiento);
        return ResponseEntity.status(201).body(seguimientoGuardado);
    }

    /**
     * Actualizar un seguimiento existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<Seguimiento> actualizarSeguimiento(@PathVariable Integer id, 
                                                             @RequestBody Seguimiento seguimiento) {
        if (seguimiento == null) {
            return ResponseEntity.badRequest().build();
        }
        
        Seguimiento seguimientoExistente = seguimientoService.findById(id);
        if (seguimientoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        
        seguimiento.setId(id);
        Seguimiento seguimientoActualizado = seguimientoService.save(seguimiento);
        return ResponseEntity.ok(seguimientoActualizado);
    }

    /**
     * Eliminar un seguimiento
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSeguimiento(@PathVariable Integer id) {
        Seguimiento seguimiento = seguimientoService.findById(id);
        if (seguimiento == null) {
            return ResponseEntity.notFound().build();
        }
        
        seguimientoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Obtener seguimientos por estado
     */
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Seguimiento>> obtenerSeguimientosPorEstado(@PathVariable String estado) {
        List<Seguimiento> seguimientos = seguimientoService.findByEstado(estado);
        return ResponseEntity.ok(seguimientos);
    }
} 