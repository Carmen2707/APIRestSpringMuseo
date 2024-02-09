package com.example.apirestspringmuseo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MuseoRepository extends JpaRepository<Museo, Long> {
    //Consultas GET simples.
    public Museo getMuseoById(Long id);

    public Museo getMuseoByNombre(String nombre);

    public Museo getMuseoByUbicacion(String ubicacion);

    public Museo getMuseoByHorario(String horario);

    public Museo getMuseoByPrecio(Double precio);

    public Museo getMuseoByCodigo(Integer codigo);

    public Museo getMuseoByWeb(String web);

    public Museo getMuseoByDescripcion(String descripcion);



    @Query("SELECT m FROM Museo m WHERE m.precio=0.00")
    public List<Museo> museosEntradaGratis();
    @Query("SELECT m.nombre FROM Museo m")
    public List<String> nombreMuseos();

    @Query("SELECT COUNT(m) FROM Museo m")
    public Integer cuantosMuseosHay();

    @Query("SELECT m.nombre, m.precio FROM Museo m")
        public List<Object> preciosMuseos();

    @Query("SELECT m FROM Museo m WHERE m.horario LIKE 'Todos los días%'")
    public List<Museo> museosAbrenSiempre();

    @Query("SELECT m.descripcion FROM Museo m WHERE m.nombre = :nombre")
    public String descripcionByNombre(@Param("nombre") String nombre);
}
