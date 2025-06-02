package com.example.municipalidad_san_antonio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "revisor_tecnico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevisorTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRevisor;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    public String apellido;

    @Column
    private String email;
}