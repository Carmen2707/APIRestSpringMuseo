package com.example.apirestspringmuseo.cuadro;

import com.example.apirestspringmuseo.museo.Museo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cuadros")
public class Cuadro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer fecha;
    private String autor;

    @ManyToOne
    @JoinColumn(name = "museo", referencedColumnName = "nombre")

    private Museo museo;


}
