package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.IntegracionMinvu;
import com.example.municipalidad_san_antonio.model.Solicitud;
import com.example.municipalidad_san_antonio.service.IntegracionMinvuService;
import com.example.municipalidad_san_antonio.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/integracion-minvu")
public class IntegracionMinvuController {
    
    @Autowired
    private IntegracionMinvuService integracionMinvuService;
    
    @Autowired
    private SolicitudService solicitudService;

    // ===== CRUD PARA INTEGRACION MINVU =====
    
    /**
     * Obtener todas las integraciones MINVU
     */
    @GetMapping("/registros")
    public ResponseEntity<List<IntegracionMinvu>> listarIntegraciones() {
        return ResponseEntity.ok(integracionMinvuService.listar());
    }

    /**
     * Obtener una integración MINVU por ID
     */
    @GetMapping("/registros/{id}")
    public ResponseEntity<IntegracionMinvu> obtenerIntegracionPorId(@PathVariable Integer id) {
        return integracionMinvuService.listar().stream()
            .filter(i -> i.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crear una nueva integración MINVU
     */
    @PostMapping("/registros")
    public ResponseEntity<IntegracionMinvu> guardarIntegracion(@RequestBody IntegracionMinvu integracionMinvu) {
        return ResponseEntity.ok(integracionMinvuService.guardar(integracionMinvu));
    }

    /**
     * Actualizar una integración MINVU existente
     */
    @PutMapping("/registros/{id}")
    public ResponseEntity<IntegracionMinvu> actualizarIntegracion(@PathVariable Integer id, @RequestBody IntegracionMinvu integracionMinvu) {
        integracionMinvu.setId(id);
        return ResponseEntity.ok(integracionMinvuService.guardar(integracionMinvu));
    }

    /**
     * Eliminar una integración MINVU
     */
    @DeleteMapping("/registros/{id}")
    public ResponseEntity<Void> eliminarIntegracion(@PathVariable Integer id) {
        integracionMinvuService.listar().removeIf(i -> i.getId().equals(id));
        return ResponseEntity.noContent().build();
    }

    // ===== OPERACIONES DE INTEGRACIÓN CON MINVU =====
    
    /**
     * Enviar solicitud a MINVU
     */
    @PostMapping("/enviar-solicitud")
    public ResponseEntity<?> enviarSolicitudAMinvu(@RequestParam Solicitud solicitud) {
        if (solicitud == null || solicitud.getIdSolicitud() == null) {
            return ResponseEntity.badRequest().body("Solicitud inválida");
        }
        
        Solicitud solicitudEncontrada = solicitudService.findById(solicitud.getIdSolicitud());
        if (solicitudEncontrada == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Aquí se podría agregar lógica adicional para el envío real a MINVU
        // Por ejemplo, crear un registro en IntegracionMinvu
        
        return ResponseEntity.status(200).body("Información enviada correctamente a MINVU");
    }
    
    /**
     * Obtener estado de una solicitud en MINVU
     */
    @GetMapping("/estado-solicitud/{id}")
    public ResponseEntity<?> obtenerEstadoSolicitud(@PathVariable Integer id) {
        Solicitud solicitud = solicitudService.findById(id);
        if (solicitud == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(200).body(solicitud);
    }
    
    /**
     * Guardar solicitud desde MINVU
     */
    @PostMapping("/guardar-solicitud")
    public ResponseEntity<?> guardarSolicitudDesdeMinvu(@RequestBody Solicitud solicitud) {
        if (solicitud == null) {
            return ResponseEntity.badRequest().body("Solicitud inválida");
        }
        
        Solicitud solicitudGuardada = solicitudService.save(solicitud);
        return ResponseEntity.status(200).body(solicitudGuardada);
    }

    /**
     * Obtener integraciones por estado de envío
     */
    @GetMapping("/registros/estado/{estadoEnvio}")
    public ResponseEntity<List<IntegracionMinvu>> obtenerIntegracionesPorEstado(@PathVariable String estadoEnvio) {
        List<IntegracionMinvu> integraciones = integracionMinvuService.findByEstadoEnvio(estadoEnvio);
        return ResponseEntity.ok(integraciones);
    }

    /**
     * Obtener integraciones por expediente
     */
    @GetMapping("/registros/expediente/{expedienteId}")
    public ResponseEntity<List<IntegracionMinvu>> obtenerIntegracionesPorExpediente(@PathVariable Integer expedienteId) {
        List<IntegracionMinvu> integraciones = integracionMinvuService.findByExpedienteId(expedienteId);
        return ResponseEntity.ok(integraciones);
    }
} 