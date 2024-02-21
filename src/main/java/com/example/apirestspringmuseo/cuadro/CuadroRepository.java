package com.example.apirestspringmuseo.cuadro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CuadroRepository extends JpaRepository<Cuadro, Long> {
    //Consultas GET cuadros.
    Cuadro getCuadroById(Long id);

    Cuadro getCuadroByNombre(String nombre);

    Cuadro getCuadroByFecha(Integer fecha);

    List<Cuadro> getCuadroByAutor(String autor);

    @Query("SELECT c FROM Cuadro c WHERE c.museo.nombre = :nombreMuseo")
    List<Cuadro> getCuadroByMuseo(@Param("nombreMuseo") String nombreMuseo);

    @Query("SELECT COUNT(c) FROM Cuadro c")
    Integer cuantosCuadrosHay();

    @Query("SELECT DISTINCT c.autor FROM Cuadro c")
    List<String> listaAutores();

    @Query("SELECT c.nombre, c.museo.nombre FROM Cuadro c")
    List<Object> listaUbicacionCuadros();

    @Query("SELECT c.nombre, c.fecha, c.autor FROM Cuadro c")
    List<Object> detallesCuadros();

}
