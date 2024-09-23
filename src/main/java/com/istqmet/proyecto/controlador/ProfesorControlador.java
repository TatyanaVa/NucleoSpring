package com.istqmet.proyecto.controlador;

import org.springframework.web.bind.annotation.GetMapping;

public class ProfesorControlador {
    @GetMapping("/Profesor")
    public String paginaListarProfesor(){

        return "/Profesor/listarProfesor";
    }
    @GetMapping("/profesor")
    public String paginaNuevoProfesor(){

        return "/Profesor/nuevoProfesor";
    }
}
