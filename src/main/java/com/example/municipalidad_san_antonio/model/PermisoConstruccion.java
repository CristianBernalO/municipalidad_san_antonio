package com.example.municipalidad_san_antonio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "permiso_construccion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermisoConstruccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPermiso;

    @Column
    private Integer idSolicitud;

    @Column(length = 30)
    private String codigoPermiso;

    @Column(length = 100)
    private String nombreSolicitante;

    @Column(length = 255)
    private String tipoPermiso;

    @Column(length = 100)
    private String firmaAutorizante;
}
