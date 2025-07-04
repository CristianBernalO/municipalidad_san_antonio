package com.example.municipalidad_san_antonio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "firma_electronica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FirmaElectronica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer documentoId;
    private String firmante;
    private LocalDateTime fechaFirma;
    private String tipoFirma; // SIMPLE, AVANZADA
    
    // Getters y setters manuales
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getDocumentoId() {
        return documentoId;
    }
    
    public void setDocumentoId(Integer documentoId) {
        this.documentoId = documentoId;
    }
    
    public String getFirmante() {
        return firmante;
    }
    
    public void setFirmante(String firmante) {
        this.firmante = firmante;
    }
    
    public LocalDateTime getFechaFirma() {
        return fechaFirma;
    }
    
    public void setFechaFirma(LocalDateTime fechaFirma) {
        this.fechaFirma = fechaFirma;
    }
    
    public String getTipoFirma() {
        return tipoFirma;
    }
    
    public void setTipoFirma(String tipoFirma) {
        this.tipoFirma = tipoFirma;
    }
} 