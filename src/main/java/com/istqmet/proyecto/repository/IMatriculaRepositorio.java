package com.istqmet.proyecto.repository;

import com.istqmet.proyecto.modelo.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMatriculaRepositorio extends JpaRepository<Matricula,Integer> {
}
