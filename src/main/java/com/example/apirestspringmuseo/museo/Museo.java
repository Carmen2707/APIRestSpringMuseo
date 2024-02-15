package com.example.apirestspringmuseo.museo;

import com.example.apirestspringmuseo.cuadro.Cuadro;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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
    @JsonIgnore
    @OneToMany(mappedBy = "museo", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Cuadro> cuadros;

    public Museo() {
    }
}
