package com.example.municipalidad_san_antonio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seguimiento {

    private Integer id;
    private String estado;
    private String mensaje;

}
