package com.istqmet.proyecto.repository;

import com.istqmet.proyecto.modelo.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstudianteRepositorio extends JpaRepository<Estudiante,Integer> {
}
