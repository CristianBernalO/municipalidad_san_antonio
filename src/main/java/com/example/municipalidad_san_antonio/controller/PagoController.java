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
    //Obtener un Pago por su ID
    @GetMapping("/api/v1/pagos/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Pago pago = pagoService.findById(id);
        if (pago == null) {
            return ResponseEntity.status(404).body("pago no encontrad0");
        }
        return ResponseEntity.status(200).body(pago);
    }
    @GetMapping("/api/v1/pagos")
    public ResponseEntity<?> findAllPagos() {
        List<Pago> pagos = pagoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(pagos);
    }
}
