package com.example.apirestspringmuseo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CuadroRepository extends JpaRepository<Cuadro, Long> {


    //Consultas GET cuadros.
    public Cuadro getCuadroById(Long id);
}
