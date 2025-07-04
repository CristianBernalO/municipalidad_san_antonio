package com.example.municipalidad_san_antonio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "integracion_minvu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IntegracionMinvu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer expedienteId;
    private String estadoEnvio; // PENDIENTE, ENVIADO, ERROR
    private LocalDateTime fechaEnvio;
    private String respuestaMinvu;
    
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
    
    public String getEstadoEnvio() {
        return estadoEnvio;
    }
    
    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }
    
    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }
    
    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
    
    public String getRespuestaMinvu() {
        return respuestaMinvu;
    }
    
    public void setRespuestaMinvu(String respuestaMinvu) {
        this.respuestaMinvu = respuestaMinvu;
    }
} 