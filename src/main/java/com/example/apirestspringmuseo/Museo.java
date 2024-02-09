package com.example.apirestspringmuseo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "museos")
public class Museo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String ubicacion;
    private String horario;
    private Double precio;
    private Integer codigo;
    private String web;
    private String descripcion;
}
