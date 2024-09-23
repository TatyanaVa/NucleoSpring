package com.istqmet.proyecto.servicio.impl;

import com.istqmet.proyecto.modelo.Profesor;
import com.istqmet.proyecto.repository.IProfesorRepositorio;
import com.istqmet.proyecto.servicio.IProfesorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class ProfesorServicioImpl implements IProfesorServicio {

    @Autowired
    private IProfesorRepositorio insertarProfesor;
    @Override
    public void insertarProfesor(Profesor profesor) {
        insertarProfesor.save(profesor);

    }
}
