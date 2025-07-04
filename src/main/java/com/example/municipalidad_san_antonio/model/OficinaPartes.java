package com.example.municipalidad_san_antonio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "oficina_partes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OficinaPartes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer expedienteId;
    private LocalDateTime fechaIngreso;
    private String estadoDistribucion;
    
    // Getters y setters manuales
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getExpedienteId() {
        return expedienteId;
    }
    
    public void setExpedienteId(Integer expedienteId) {
        this.expedienteId = expedienteId;
    }
    
    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }
    
    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public String getEstadoDistribucion() {
        return estadoDistribucion;
    }
    
    public void setEstadoDistribucion(String estadoDistribucion) {
        this.estadoDistribucion = estadoDistribucion;
    }
} 