package com.example.apirestspringmuseo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cuadro")
public class CuadroController {
    @Autowired //inicializar los componentes de sprint de forma automatica
    private CuadroController repositorio;

    //METODOS GET.

    @GetMapping("/id/{id}")
    public Museo getCuadroById(@PathVariable Long id) {
        return repositorio.getCuadroById(id);
    }
}
