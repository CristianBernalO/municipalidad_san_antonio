package com.example.municipalidad_san_antonio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Solicitud")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSolicitud;

    @Column(nullable = false, length = 100)
    private String nombreSolicitante;

    @Column(nullable = false, unique = true)
    private String rutSolicitante;

    @Column(nullable = false)
    private Date fechaSolicitud;

    @Column(nullable = false)
    private String estadoSolicitud;

    @Column
    private String observacionSolicitud;
}
