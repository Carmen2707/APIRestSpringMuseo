package com.example.apirestspringmuseo.museo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MuseoRepository extends JpaRepository<Museo, Long> {
    //Consultas GET museo.
    Museo getMuseoById(Long id);

    Museo getMuseoByNombre(String nombre);

    Museo getMuseoByUbicacion(String ubicacion);

    Museo getMuseoByHorario(String horario);

    Museo getMuseoByPrecio(Double precio);

    Museo getMuseoByCodigo(Integer codigo);

    Museo getMuseoByWeb(String web);

    Museo getMuseoByDescripcion(String descripcion);

    @Query("SELECT m FROM Museo m WHERE m.precio=0.00")
    List<Museo> museosEntradaGratis();

    @Query("SELECT m.nombre FROM Museo m")
    List<String> nombreMuseos();

    @Query("SELECT COUNT(m) FROM Museo m")
    Integer cuantosMuseosHay();

    @Query("SELECT m.nombre, m.precio FROM Museo m")
    List<Object> preciosMuseos();

    @Query("SELECT m FROM Museo m WHERE m.horario LIKE 'Todos los días%'")
    List<Museo> museosAbrenSiempre();

    @Query("SELECT m.nombre, m.web FROM Museo m")
    List<Object> listaWebs();

}
