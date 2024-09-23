package com.istqmet.proyecto.repository;

import com.istqmet.proyecto.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepositorio extends JpaRepository<Curso,Integer> {
}
