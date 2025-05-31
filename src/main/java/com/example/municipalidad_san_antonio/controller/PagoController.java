package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagoController {

    @Autowired
    private PagoService pagoService;


}
