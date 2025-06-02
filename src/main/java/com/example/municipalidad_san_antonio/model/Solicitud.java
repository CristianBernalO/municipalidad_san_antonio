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

    @Column
    private Integer idRevisorTecnico;

    @Column(length = 100)
    private String nombreSolicitante;

    @Column(unique = true)
    private String rutSolicitante;

    @Column
    private Date fechaSolicitud;

    @Column
    private String estadoSolicitud;

    @Column
    private String observacionSolicitud;

    @Column
    private boolean solicitudAceptada = false;
}
