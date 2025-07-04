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

    // Métodos getter y setter manuales para resolver problemas de compilación
    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Integer getIdRevisorTecnico() {
        return idRevisorTecnico;
    }

    public void setIdRevisorTecnico(Integer idRevisorTecnico) {
        this.idRevisorTecnico = idRevisorTecnico;
    }

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public String getRutSolicitante() {
        return rutSolicitante;
    }

    public void setRutSolicitante(String rutSolicitante) {
        this.rutSolicitante = rutSolicitante;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getObservacionSolicitud() {
        return observacionSolicitud;
    }

    public void setObservacionSolicitud(String observacionSolicitud) {
        this.observacionSolicitud = observacionSolicitud;
    }

    public boolean isSolicitudAceptada() {
        return solicitudAceptada;
    }

    public void setSolicitudAceptada(boolean solicitudAceptada) {
        this.solicitudAceptada = solicitudAceptada;
    }
}
