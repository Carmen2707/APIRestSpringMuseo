package com.example.apirestspringmuseo.cuadro;

import com.example.apirestspringmuseo.SecurityService;

import com.example.apirestspringmuseo.museo.Museo;
import com.example.apirestspringmuseo.museo.MuseoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuadro")
public class CuadroController {
    @Autowired //inicializar los componentes de sprint de forma automatica
    private CuadroRepository repositorioCuadro;
    @Autowired //inicializar los componentes de sprint de forma automatica
    private MuseoRepository museoRepository;
    //METODOS GET.

    /**
     * @param id del cuadro
     * @return Devuelve el cuadro con el id pasado como parámetro.
     */
    @GetMapping("/id/{id}")
    public Cuadro getCuadroById(@PathVariable Long id) {
        return repositorioCuadro.getCuadroById(id);
    }

    /**
     * @param nombre del cuadro
     * @return Devuelve el cuadro con el nombre pasado como parámetro.
     */
    @GetMapping("/nombre/{nombre}")
    public Cuadro getCuadroByNombre(@PathVariable String nombre) {
        return repositorioCuadro.getCuadroByNombre(nombre);
    }

    /**
     * @param fecha del cuadro
     * @return Devuelve el cuadro con la fecha pasada como parámetro.
     */
    @GetMapping("/fecha/{fecha}")
    public Cuadro getCuadroByFecha(@PathVariable Integer fecha) {
        return repositorioCuadro.getCuadroByFecha(fecha);
    }

    /**
     * @param autor del cuadro
     * @return Devuelve el cuadro con el autor pasado como parámetro.
     */
    @GetMapping("/autor/{autor}")
    public List<Cuadro> getCuadroByAutor(@PathVariable String autor) {
        return repositorioCuadro.getCuadroByAutor(autor);
    }

    /**
     * @param nombre del museo
     * @return Devuelve el cuadro con el nombre del museo en el que se encuentra pasado como parámetro.
     */
    @GetMapping("/museo/{nombre}")
    public List<Cuadro> getCuadroByMuseo(@PathVariable String nombre) {
        return repositorioCuadro.getCuadroByMuseo(nombre);
    }

    /**
     * @return Devuelve el número total de cuadros que hay en la base de datos.
     */
@GetMapping("/totalCuadros")
    public Integer getTotalCuadros(){
        return repositorioCuadro.cuantosCuadrosHay();
}

    /**
     * @return Devuelve una lista con el nombre de todos los autores que hay en la base de datos.
     */
@GetMapping("/listaAutores")
    public List<String> getTodosAutores(){
        return repositorioCuadro.listaAutores();
}

    /**
     * @return Devuelve una lista con todos los cuadros junto con el nombre del museo en el que se encuentran.
     */
@GetMapping("/ubicacionCuadro")
public List<Object> getUbicacionCuadros(){
        return repositorioCuadro.listaUbicacionCuadros();
}

    /**
     * @return Devuelve una lista con todos los cuadros y su información.
     */
@GetMapping("/detallesCuadros")
    public List<Object> getDetallesCuadros(){
        return repositorioCuadro.detallesCuadros();
}


//METODOS POST.

    @Autowired
    private SecurityService security;

    /**
     * @param cuadro cuadro nuevo
     * @param token token para validar
     * @return Crea un nuevo cuadro, sólo si el token es válido.
     */
    @PostMapping("/post")
    public ResponseEntity<Cuadro> nuevo(@RequestBody Cuadro cuadro, @RequestParam String token) {
        if (security.validateToken(token)) {
            // Verificar si el cuadro tiene un museo asignado
            if (cuadro.getMuseo() != null) {
                // Obtener el museo del repositorio por su nombre
                Museo museo = museoRepository.findByNombre(cuadro.getMuseo().getNombre());

                if (museo != null) {
                    // Asignar el museo al cuadro
                    cuadro.setMuseo(museo);
                    // Guardar el cuadro en el repositorio
                    Cuadro cuadroGuardado = repositorioCuadro.save(cuadro);
                    return new ResponseEntity<>(cuadroGuardado, HttpStatus.OK);
                } else {
                    // El museo no existe en la base de datos
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } else {
                // El cuadro no tiene un museo asignado
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    //METODOS PUT.
    /**
     * @param id del cuadro
     * @param cuadroNuevo nuevo cuadro creado
     * @param token token para validar
     * @return Actualiza un cuadro que ya exista, o lo guarda si no existe (solo si el token es correcto)
     *
     */
    @PutMapping("/{id}")
    public ResponseEntity<Cuadro> put(@PathVariable Long id, @RequestBody Cuadro cuadroNuevo, @RequestParam String token){

        if( !security.validateToken(token) ){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else{
            var cuadro = new Cuadro();

            var cuadroSelect = repositorioCuadro.findById(id);

            if(cuadroSelect.isEmpty()){
                cuadro = cuadroNuevo;
            } else{
                cuadro = cuadroSelect.get();
                cuadro.setNombre( cuadroNuevo.getNombre() );
                cuadro.setFecha( cuadroNuevo.getFecha() );
                cuadro.setAutor( cuadroNuevo.getAutor() );
                cuadro.setMuseo( cuadroNuevo.getMuseo() );
            }

            return new ResponseEntity<>(repositorioCuadro.save(cuadro), HttpStatus.OK);
        }

    }
    //METODOS DELETE.
    /**
     * @param id del cuadro
     * @param token token para validar
     * @return Si el token es válido, elimina el cuadro pasado por parámetro
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Cuadro> delete(@PathVariable Long id,  @RequestParam String token){

        ResponseEntity<Cuadro> respuesta = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        if( security.validateToken(token) ){
            Cuadro salida = new Cuadro();
            if (repositorioCuadro.existsById(id)) {
                salida = repositorioCuadro.findById(id).get();
                repositorioCuadro.deleteById(id);
                respuesta = new ResponseEntity<>(salida, HttpStatus.OK);
            } else {
                respuesta = new ResponseEntity<>(salida, HttpStatus.NOT_FOUND);
            }
        }
        return respuesta;
    }

}
