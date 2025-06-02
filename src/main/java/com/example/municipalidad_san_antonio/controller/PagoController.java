package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.Pago;
import com.example.municipalidad_san_antonio.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PagoController {

    @Autowired
    private PagoService pagoService;
    //Obtener una orden de Pago por su ID
    @GetMapping("/api/v1/pagos/{id}/orden")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Pago pago = pagoService.findById(id);
        if (pago == null) {
            return ResponseEntity.status(404).body("pago no encontrad0");
        }
        return ResponseEntity.status(200).body(pago);
    }
    //Enviar datos a traves de integración de medio de pago
    @PostMapping("/api/v1/pagos/{id}/confirmar")
    public ResponseEntity<?> savePago(@PathVariable Integer id, @RequestBody Pago pago) {
        if (pago == null) {
            return ResponseEntity.status(404).body("pago no encontrad0");
        }
        pagoService.save(pago);
        return ResponseEntity.status(201).body("Datos de pago enviados");
    }
    //Obtener el estado del pago por su ID
    @GetMapping("/api/v1/pagos/{id}/estado")
    public ResponseEntity<?> findEstadoPago(@PathVariable Integer id) {
        Pago pago = pagoService.findById(id);
        if (pago == null) {
            return ResponseEntity.status(404).body("pago no encontrad0");
        }
        return ResponseEntity.status(200).body(pago.getEstadoPago());
    }
}
