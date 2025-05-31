package com.example.municipalidad_san_antonio.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

public class Integracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String codigo;

    @Column(length = 50)
    private String estado;

    @Column(length = 255)
    private String mensaje;
}
