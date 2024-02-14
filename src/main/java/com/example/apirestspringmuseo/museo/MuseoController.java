package com.example.apirestspringmuseo.museo;

import com.example.apirestspringmuseo.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/museo")
public class MuseoController {
    @Autowired //inicializar los componentes de sprint de forma automatica
    private MuseoRepository repositorio;

    //METODOS GET.

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


    /**
     * @return Devuelve el nombre de los museos junto con su página web.
     */
    @GetMapping("/listaWebs")
    public List<Object> getListaWebs(){
        return repositorio.listaWebs();
    }



    //METODOS POST.

    @Autowired
    private SecurityService security;

    /**
     * @param museo objeto msuseo
     * @param token token para validar
     * @return Crea un museo nuevo, pero solo si el token es válido.
     */
    @PostMapping("/post")
    public ResponseEntity<Museo> nuevo(@RequestBody Museo museo, @RequestParam String token) {
        if (security.validateToken(token)) {
            return new ResponseEntity<Museo>(repositorio.save(museo), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    //METODOS PUT.


    /**
     * @param id del museo
     * @param museoNuevo nuevo museo creado
     * @param token token para validar
     * @return Actualiza un museo que ya exista, o lo guarda si no existe (solo si el token es correcto)
     *
     */
    @PutMapping("/{id}")
    public ResponseEntity<Museo> put(@PathVariable Long id, @RequestBody Museo museoNuevo, @RequestParam String token){

        if( !security.validateToken(token) ){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else{
            var museo = new Museo();

            var museoSelect = repositorio.findById(id);

            if(museoSelect.isEmpty()){
                museo = museoNuevo;
            } else{
                museo = museoSelect.get();
                museo.setNombre( museoNuevo.getNombre() );
                museo.setUbicacion( museoNuevo.getUbicacion() );
                museo.setHorario( museoNuevo.getHorario() );
                museo.setPrecio( museoNuevo.getPrecio() );
                museo.setCodigo(museoNuevo.getCodigo());
                museo.setWeb(museoNuevo.getWeb());
                museo.setDescripcion(museoNuevo.getDescripcion());
            }

            return new ResponseEntity<Museo>(repositorio.save(museo),HttpStatus.OK);
        }

    }

    /**
     * @param id del museo
     * @param token token validar
     * @return Si el token es válido, elimina el museo pasado por parámetro
     */
    //METODOS DELETE.
    @DeleteMapping("/{id}")
    public ResponseEntity<Museo> delete(@PathVariable Long id,  @RequestParam String token){

        ResponseEntity<Museo> respuesta = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        if( security.validateToken(token) ){
            Museo salida = new Museo();
            if (repositorio.existsById(id)) {
                salida = repositorio.findById(id).get();
                repositorio.deleteById(id);
                respuesta = new ResponseEntity<Museo>(salida, HttpStatus.OK);
            } else {
                respuesta = new ResponseEntity<Museo>(salida, HttpStatus.NOT_FOUND);
            }
        }
        return respuesta;
    }

}
