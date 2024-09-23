package com.istqmet.proyecto.servicio;

import com.istqmet.proyecto.modelo.Profesor;
import com.istqmet.proyecto.repository.IProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

public interface IProfesorServicio {


    public void insertarProfesor(Profesor profesor);

}
