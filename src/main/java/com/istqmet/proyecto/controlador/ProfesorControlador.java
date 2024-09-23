package com.istqmet.proyecto.controlador;

import com.istqmet.proyecto.modelo.Profesor;
import com.istqmet.proyecto.repository.IProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProfesorControlador {

    @Autowired
    private IProfesorRepositorio profesorRepositorio;

    @GetMapping("/profesorListar")
    public String listarProfesores(Model model) {
        List<Profesor> listaProfesores = profesorRepositorio.findAll();
        model.addAttribute("profesores", listaProfesores);
        return "Profesor/listarProfesor"; // Ajusta el nombre de la vista según tu estructura
    }

    @GetMapping("/profesorNuevo")
    public String paginaNuevoProfesor(Model model) {
        model.addAttribute("profesor", new Profesor());
        return "Profesor/nuevoProfesor"; // Ajusta el nombre de la vista según tu estructura
    }

    @PostMapping("/nuevaProfesor")
    public String guardarProfesor(Profesor profesor) {
        profesorRepositorio.save(profesor);
        return "redirect:/profesorListar";
    }

    @GetMapping("/profesorEditar/{idProfesor}")
    public String paginaEditarProfesor(@PathVariable int idProfesor, Model model) {
        Profesor profesor = profesorRepositorio.findById(idProfesor)
                .orElseThrow(() -> new IllegalArgumentException("Profesor no encontrado"));
        model.addAttribute("profesor", profesor);
        return "Profesor/editarProfesor"; // Ajusta el nombre de la vista según tu estructura
    }

    @PostMapping("/profesorEditar/{idProfesor}")
    public String actualizarProfesor(@PathVariable int idProfesor, Profesor profesorActualizado) {
        profesorActualizado.setIdProfesor(idProfesor);
        profesorRepositorio.save(profesorActualizado);
        return "redirect:/profesorListar";
    }

    @GetMapping("/profesorEliminar/{idProfesor}")
    public String eliminarProfesor(@PathVariable int idProfesor) {
        profesorRepositorio.deleteById(idProfesor);
        return "redirect:/profesorListar";
    }
}
