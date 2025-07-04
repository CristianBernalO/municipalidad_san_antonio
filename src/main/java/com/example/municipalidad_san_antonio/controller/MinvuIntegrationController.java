package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.Solicitud;
import com.example.municipalidad_san_antonio.service.SeguimientoService;
import com.example.municipalidad_san_antonio.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/minvu-integration")
public class MinvuIntegrationController {

    @Autowired
    private SolicitudService solicitudService;

    @PostMapping("/enviar-solicitud")
    public ResponseEntity<?> sendSolicitud(@RequestParam Solicitud solicitud) {
        solicitudService.findById(solicitud.getIdSolicitud());
        return ResponseEntity.status(200).body("Información enviada correctamente a MINVU");
    }
    
    @GetMapping("/estado/{id}")
    public ResponseEntity<?> getEstado(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(solicitudService.findById(id));
    }
    
    @PostMapping("/guardar-solicitud")
    public ResponseEntity<?> saveSolicitud(@RequestBody Solicitud solicitud) {
        return ResponseEntity.status(200).body(solicitudService.save(solicitud));
    }
} 