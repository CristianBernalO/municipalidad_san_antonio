package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.Solicitud;
import com.example.municipalidad_san_antonio.service.SeguimientoService;
import com.example.municipalidad_san_antonio.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IntegracionController {

    @Autowired
    private SolicitudService solicitudService;

    @PostMapping("/api/v1/integracion/minvu")
    public ResponseEntity<?> sendSolicitud(@RequestParam Solicitud solicitud) {
        solicitudService.findById(solicitud.getIdSolicitud());
        return ResponseEntity.status(200).body("Informacion enviada correctamente");
    }
    @GetMapping("/api/v1/integracion/minvu/estado/{id}")
    public ResponseEntity<?> getEstado(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(solicitudService.findById(id));
    }
    @PostMapping("/api/v1/integracion/minvu/guardarSolicitud")
    public ResponseEntity<?> saveSolicitud(@RequestBody Solicitud solicitud) {
        return ResponseEntity.status(200).body(solicitudService.save(solicitud));
    }
}
