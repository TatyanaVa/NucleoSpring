package com.istqmet.proyecto.controlador;

import com.istqmet.proyecto.modelo.Aula;
import com.istqmet.proyecto.repository.IAulaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AulaControlador {

    @Autowired
    private  IAulaRepositorio aulaRepositorio;

    @GetMapping("/aulaListar")
    public String listarAulas(Model model) {
        List<Aula> listaAulas = aulaRepositorio.findAll();
        model.addAttribute("aulas", listaAulas);
        return "Aula/listarAula";
    }

    @GetMapping("/aulaNueva")
    public String paginaNuevaAula(Model model) {
        model.addAttribute("aula", new Aula());
        return "Aula/nuevaAula";
    }

    @PostMapping("/nuevaAula")
    public String guardarAula(Aula aula) {
        aulaRepositorio.save(aula);
        return "redirect:/aulaListar";
    }
    @GetMapping("/aulaEditar/{idAula}")
    public String paginaEditarAula(@PathVariable int idAula, Model model) {
        Aula aula = aulaRepositorio.findById(idAula).orElseThrow(() -> new IllegalArgumentException("Aula no encontrada"));
        model.addAttribute("aula", aula);
        return "Aula/editarAula";
    }
    @PostMapping("/aulaEditar/{idAula}")
    public String actualizarAula(@PathVariable int idAula, Aula aulaActualizada) {
        aulaActualizada.setIdAula(idAula);
        aulaRepositorio.save(aulaActualizada);
        return "redirect:/aulaListar";
    }

        @GetMapping("/aulaEliminar/{idAula}")
        public String eliminarAula(@PathVariable int idAula) {
            aulaRepositorio.deleteById(idAula);
            return "redirect:/aulaListar";
        }
}
