package com.istqmet.proyecto.repository;

import com.istqmet.proyecto.modelo.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfesorRepositorio extends JpaRepository<Profesor,Integer> {
}
