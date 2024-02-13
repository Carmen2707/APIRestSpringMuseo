package com.example.apirestspringmuseo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "cuadros")
public class Cuadro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Date fecha;
    private String autor;

    @ManyToOne
    @JoinColumn(name = "museo")
    @JsonIgnore
    private Museo museo;
}
