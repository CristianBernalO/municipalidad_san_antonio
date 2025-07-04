package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.PermisoConstruccion;
import com.example.municipalidad_san_antonio.service.PermisoConstruccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/permisos-construccion")
public class PermisoConstruccionController {

    @Autowired
    private PermisoConstruccionService permisoConstruccionService;

    /**
     * Obtener todos los permisos de construcción
     */
    @GetMapping
    public ResponseEntity<List<PermisoConstruccion>> obtenerTodosLosPermisos() {
        List<PermisoConstruccion> permisos = permisoConstruccionService.findAll();
        return ResponseEntity.ok(permisos);
    }

    /**
     * Obtener un permiso de construcción por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<PermisoConstruccion> obtenerPermisoPorId(@PathVariable Integer id) {
        PermisoConstruccion permiso = permisoConstruccionService.findById(id);
        if (permiso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(permiso);
    }

    /**
     * Crear un nuevo permiso de construcción
     */
    @PostMapping
    public ResponseEntity<PermisoConstruccion> crearPermiso(@RequestBody PermisoConstruccion permiso) {
        if (permiso == null) {
            return ResponseEntity.badRequest().build();
        }
        // Aquí se podría agregar lógica adicional de validación
        PermisoConstruccion permisoGuardado = permisoConstruccionService.save(permiso);
        return ResponseEntity.status(201).body(permisoGuardado);
    }

    /**
     * Actualizar un permiso de construcción existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<PermisoConstruccion> actualizarPermiso(@PathVariable Integer id, 
                                                                 @RequestBody PermisoConstruccion permiso) {
        if (permiso == null) {
            return ResponseEntity.badRequest().build();
        }
        
        PermisoConstruccion permisoExistente = permisoConstruccionService.findById(id);
        if (permisoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        
        permiso.setIdPermiso(id);
        PermisoConstruccion permisoActualizado = permisoConstruccionService.save(permiso);
        return ResponseEntity.ok(permisoActualizado);
    }

    /**
     * Eliminar un permiso de construcción
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPermiso(@PathVariable Integer id) {
        PermisoConstruccion permiso = permisoConstruccionService.findById(id);
        if (permiso == null) {
            return ResponseEntity.notFound().build();
        }
        
        permisoConstruccionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Obtener permisos por tipo
     */
    @GetMapping("/tipo/{tipoPermiso}")
    public ResponseEntity<List<PermisoConstruccion>> obtenerPermisosPorTipo(@PathVariable String tipoPermiso) {
        List<PermisoConstruccion> permisos = permisoConstruccionService.findByTipoPermiso(tipoPermiso);
        return ResponseEntity.ok(permisos);
    }

    /**
     * Obtener permisos por solicitante
     */
    @GetMapping("/solicitante/{nombreSolicitante}")
    public ResponseEntity<List<PermisoConstruccion>> obtenerPermisosPorSolicitante(@PathVariable String nombreSolicitante) {
        List<PermisoConstruccion> permisos = permisoConstruccionService.findByNombreSolicitante(nombreSolicitante);
        return ResponseEntity.ok(permisos);
    }
} 