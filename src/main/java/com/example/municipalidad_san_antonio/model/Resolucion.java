package com.example.municipalidad_san_antonio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "resolucion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resolucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer solicitudId;
    private String tipo; // APROBACION, RECHAZO
    private String descripcion;
    private LocalDateTime fechaResolucion;
    
    // Getters y setters manuales
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getSolicitudId() {
        return solicitudId;
    }
    
    public void setSolicitudId(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public LocalDateTime getFechaResolucion() {
        return fechaResolucion;
    }
    
    public void setFechaResolucion(LocalDateTime fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }
} 