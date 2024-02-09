package com.example.apirestspringmuseo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/museo")
public class MuseoController {
    @Autowired //inicializar los componentes de sprint de forma automatica
    private MuseoRepository repositorio;

    /**
     * @return Devuelve todos los museos.
     */
    @GetMapping("/")
    public List<Museo> getAll() {
        return repositorio.findAll();
    }

    /**
     * @param id del museo
     * @return Devuelve el museo con el id pasado como parámetro.
     */
    @GetMapping("/id/{id}")
    public Museo getMuseoByID(@PathVariable Long id) {
        return repositorio.getMuseoById(id);
    }

    /**
     * @param nombre del museo
     * @return  Devuelve el museo con el nombre pasado como parámetro.
     */
    @GetMapping("/nombre/{nombre}")
    public Museo getMuseoByNombre(@PathVariable String nombre){
        return repositorio.getMuseoByNombre(nombre);
    }

    /**
     * @param ubicacion del museo
     * @return Devuelve el museo con la ubicación pasada como parámetro.
     */
    @GetMapping("/ubicacion/{ubicacion}")
    public Museo getMuseoByUbicacion(@PathVariable String ubicacion){
        return repositorio.getMuseoByUbicacion(ubicacion);
    }

    /**
     * @param horario de apertura y cierre del museo
     * @return Devuelve el museo con el horario pasado como parámetro.
     */
    @GetMapping("/horario/{horario}")
    public Museo getMuseoByHorario(@PathVariable String horario){
        return repositorio.getMuseoByHorario(horario);
    }

    /**
     * @param precio de la entrada al museo
     * @return Devuelve el museo con el precio de entrada pasado como parámetro.
     */
    @GetMapping("/precio/{precio}")
    public Museo getMuseoByPrecio(@PathVariable Double precio){
        return repositorio.getMuseoByPrecio(precio);
    }

    /**
     * @param codigo código postal del museo
     * @return Devuelve el museo con el código postal pasado como parámetro.
     */
    @GetMapping("/codigo/{codigo}")
    public Museo getMuseoByCodigo(@PathVariable Integer codigo){
        return repositorio.getMuseoByCodigo(codigo);
    }

    /**
     * @param web del museo
     * @return Devuelve el museo con la web pasada como parámetro.
     */
    @GetMapping("/web/{web}")
    public Museo getMuseoByWeb(@PathVariable String web){
        return repositorio.getMuseoByWeb(web);
    }

    /**
     * @param descripcion del museo
     * @return Devuelve el museo con la descripcion pasada como parámetro.
     */
    @GetMapping("/descripcion/{descripcion}")
    public Museo getMuseoByDescripcion(@PathVariable String descripcion){
        return repositorio.getMuseoByDescripcion(descripcion);
    }

    @GetMapping("/name")
    public String getDescripcionByNombre(@PathVariable String name){
        return repositorio.descripcionByNombre(name);
    }
    /**
     * @return Devuelve una lista con los museos que tienen la entrada gratis.
     */
    @GetMapping("/gratis")
    public List<Museo> getMuseoGratis() {
        return repositorio.museosEntradaGratis();
    }

    /**
     * @return Devuelve una lista con todos los nombres de los museos.
     */
    @GetMapping("/nombres")
    public List<String> getNombresMuseos(){
        return repositorio.nombreMuseos();
    }

    /**
     * @return Devuelve el total de museos que hay en la base de datos.
     */
    @GetMapping("/count")
    public Integer getTotalMuseos(){
        return repositorio.cuantosMuseosHay();
    }

    /**
     * @return Devuelve el nombre de los museos junto su precio de entrada.
     */
    @GetMapping("/precios")
    public List<Object> getNombreYPrecioMuseo(){
        return repositorio.preciosMuseos();
    }

    /**
     * @return Devuelve los museos que abren todos los días.
     */
    @GetMapping("/siempreAbierto")
    public List<Museo> getMuseosTodosDiasAbiertos(){
        return repositorio.museosAbrenSiempre();
    }


}
