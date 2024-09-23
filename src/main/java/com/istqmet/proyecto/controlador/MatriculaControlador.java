package com.istqmet.proyecto.controlador;

import org.springframework.web.bind.annotation.GetMapping;

public class MatriculaControlador {
    @GetMapping("/matricula")
    public String paginaListarMatricula(){

        return "/Matricula/listarmatricula";
    }
    @GetMapping("/matricula")
    public String paginaNuevaMatricula(){

        return "/Matricula/nuevaMatricula";
    }
}
