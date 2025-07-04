package com.example.municipalidad_san_antonio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "historial_cambios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialCambios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String entidad;
    private Integer entidadId;
    private String usuario;
    private String tipoCambio;
    private String valorAnterior;
    private String valorNuevo;
    private LocalDateTime fechaCambio;
    
    // Getters y setters manuales
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getEntidad() {
        return entidad;
    }
    
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }
    
    public Integer getEntidadId() {
        return entidadId;
    }
    
    public void setEntidadId(Integer entidadId) {
        this.entidadId = entidadId;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getTipoCambio() {
        return tipoCambio;
    }
    
    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
    
    public String getValorAnterior() {
        return valorAnterior;
    }
    
    public void setValorAnterior(String valorAnterior) {
        this.valorAnterior = valorAnterior;
    }
    
    public String getValorNuevo() {
        return valorNuevo;
    }
    
    public void setValorNuevo(String valorNuevo) {
        this.valorNuevo = valorNuevo;
    }
    
    public LocalDateTime getFechaCambio() {
        return fechaCambio;
    }
    
    public void setFechaCambio(LocalDateTime fechaCambio) {
        this.fechaCambio = fechaCambio;
    }
} 