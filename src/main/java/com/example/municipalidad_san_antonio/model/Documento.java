package com.example.municipalidad_san_antonio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "Documento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocumento;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "archivo_url")
    private String archivoUrl;

    @Column(name = "fecha_subida")
    private LocalDateTime fechaSubida;
}
