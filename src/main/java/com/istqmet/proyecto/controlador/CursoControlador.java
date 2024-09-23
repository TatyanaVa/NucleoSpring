package com.istqmet.proyecto.controlador;

import com.istqmet.proyecto.modelo.Curso;
import com.istqmet.proyecto.repository.ICursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CursoControlador {

    @Autowired
    private ICursoRepositorio cursoRepositorio;

    @GetMapping("/cursoListar")
    public String listarCursos(Model model) {
        List<Curso> listaCursos = cursoRepositorio.findAll();
        model.addAttribute("cursos", listaCursos);
        return "Curso/listarCurso";
    }

    @GetMapping("/cursoNuevo")
    public String paginaNuevoCurso(Model model) {
        model.addAttribute("curso", new Curso());
        return "Curso/nuevoCurso";
    }

    @PostMapping("/nuevaCurso")
    public String guardarCurso(Curso curso) {
        cursoRepositorio.save(curso);
        return "redirect:/cursoListar";
    }

    @GetMapping("/cursoEditar/{idCurso}")
    public String paginaEditarCurso(@PathVariable int idCurso, Model model) {
        Curso curso = cursoRepositorio.findById(idCurso)
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));
        model.addAttribute("curso", curso);
        return "Curso/editarCurso";
    }

    @PostMapping("/cursoEditar/{idCurso}")
    public String actualizarCurso(@PathVariable int idCurso, Curso cursoActualizado) {
        cursoActualizado.setIdCurso(idCurso);
        cursoRepositorio.save(cursoActualizado);
        return "redirect:/cursoListar";
    }

    @GetMapping("/cursoEliminar/{idCurso}")
    public String eliminarCurso(@PathVariable int idCurso) {
        cursoRepositorio.deleteById(idCurso);
        return "redirect:/cursoListar";
    }
}
