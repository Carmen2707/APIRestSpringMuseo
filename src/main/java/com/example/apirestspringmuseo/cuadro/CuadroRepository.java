package com.example.apirestspringmuseo.cuadro;

import com.example.apirestspringmuseo.cuadro.Cuadro;
import com.example.apirestspringmuseo.museo.Museo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.event.ListDataEvent;
import java.util.List;

public interface CuadroRepository extends JpaRepository<Cuadro, Long> {
    //Consultas GET cuadros.
    public Cuadro getCuadroById(Long id);

    public Cuadro getCuadroByNombre(String nombre);
    public Cuadro getCuadroByFecha(Integer fecha);
    public List<Cuadro> getCuadroByAutor(String autor);

    @Query("SELECT c FROM Cuadro c WHERE c.museo.nombre = :nombreMuseo")
    public List<Cuadro> getCuadroByMuseo(@Param("nombreMuseo") String nombreMuseo);

    @Query("SELECT COUNT(c) FROM Cuadro c")
    public Integer cuantosCuadrosHay();
    @Query("SELECT DISTINCT c.autor FROM Cuadro c")
    public List<String> listaAutores();

    @Query("SELECT c.nombre, c.museo.nombre FROM Cuadro c")
    public List<Object> listaUbicacionCuadros();

    @Query("SELECT c.nombre, c.fecha, c.autor FROM Cuadro c")
    public List<Object> detallesCuadros();

}
