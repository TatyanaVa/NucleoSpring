package com.istqmet.proyecto.controlador;

import com.istqmet.proyecto.modelo.Estudiante;
import com.istqmet.proyecto.repository.IEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EstudianteControlador {

    @Autowired
    private IEstudianteRepositorio estudianteRepositorio;

    @GetMapping("/estudianteListar")
    public String listarEstudiantes(Model model) {
        List<Estudiante> listaEstudiantes = estudianteRepositorio.findAll();
        model.addAttribute("estudiantes", listaEstudiantes);
        return "Estudiante/listarEstudiante";
    }

    @GetMapping("/estudianteNuevo")
    public String paginaNuevoEstudiante(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "Estudiante/nuevoEstudiante";
    }

    @PostMapping("/nuevaEstudiante")
    public String guardarEstudiante(Estudiante estudiante) {
        estudianteRepositorio.save(estudiante);
        return "redirect:/estudianteListar";
    }

    @GetMapping("/estudianteEditar/{idEstudiante}")
    public String paginaEditarEstudiante(@PathVariable int idEstudiante, Model model) {
        Estudiante estudiante = estudianteRepositorio.findById(idEstudiante)
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));
        model.addAttribute("estudiante", estudiante);
        return "Estudiante/editarEstudiante";
    }

    @PostMapping("/estudianteEditar/{idEstudiante}")
    public String actualizarEstudiante(@PathVariable int idEstudiante, Estudiante estudianteActualizado) {
        estudianteActualizado.setIdEstudiante(idEstudiante);
        estudianteRepositorio.save(estudianteActualizado);
        return "redirect:/estudianteListar";
    }

    @GetMapping("/estudianteEliminar/{idEstudiante}")
    public String eliminarEstudiante(@PathVariable int idEstudiante) {
        estudianteRepositorio.deleteById(idEstudiante);
        return "redirect:/estudianteListar";
    }
}
