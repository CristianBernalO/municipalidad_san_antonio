package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.Integracion;
import com.example.municipalidad_san_antonio.model.Solicitud;
import com.example.municipalidad_san_antonio.service.IntegracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/integracion/minvu")
@RestController
public class IntegracionController {

    @Autowired
    private IntegracionService integracionService;

    @GetMapping("/api/v1/integracion/minvu")
    public ResponseEntity<Integracion> sendSolicitud(@RequestParam Solicitud solicitud) {
        return ResponseEntity.ok(integracionService.sendSolicitud(solicitud));
    }
    @GetMapping("/api/v1/integracion/minvu/estado/{id}")
    public ResponseEntity<Integracion> getEstado(@PathVariable Long id) {
        return IntegracionService.getEstado(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/api/v1/integracion/minvu/guardarSolicitud")
    public ResponseEntity<Integracion> saveSolicitud(@RequestBody Solicitud solicitud) {
        return ResponseEntity.ok(IntegracionService.saveSolicitud(solicitud));
    }



}
