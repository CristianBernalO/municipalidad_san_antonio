package com.example.municipalidad_san_antonio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPago;

    @Column(nullable = false)
    private Integer idSolicitud;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    @Column(name = "medio_pago")
    private String medioPago;

    @Column(nullable = false)
    private Integer valor;

    @Column(name = "estado_pago", nullable = false)
    private String estadoPago;
}