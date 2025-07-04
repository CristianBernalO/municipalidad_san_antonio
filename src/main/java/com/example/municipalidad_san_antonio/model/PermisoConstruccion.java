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
    
    // Getters y setters manuales
    public Integer getIdPermiso() {
        return idPermiso;
    }
    
    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }
    
    public Integer getIdSolicitud() {
        return idSolicitud;
    }
    
    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
    
    public String getCodigoPermiso() {
        return codigoPermiso;
    }
    
    public void setCodigoPermiso(String codigoPermiso) {
        this.codigoPermiso = codigoPermiso;
    }
    
    public String getNombreSolicitante() {
        return nombreSolicitante;
    }
    
    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }
    
    public String getTipoPermiso() {
        return tipoPermiso;
    }
    
    public void setTipoPermiso(String tipoPermiso) {
        this.tipoPermiso = tipoPermiso;
    }
    
    public String getFirmaAutorizante() {
        return firmaAutorizante;
    }
    
    public void setFirmaAutorizante(String firmaAutorizante) {
        this.firmaAutorizante = firmaAutorizante;
    }
}
