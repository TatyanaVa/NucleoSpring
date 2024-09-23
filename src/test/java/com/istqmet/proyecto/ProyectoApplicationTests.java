package com.istqmet.proyecto;

import com.istqmet.proyecto.modelo.Profesor;
import com.istqmet.proyecto.servicio.IEstudianteServicio;
import com.istqmet.proyecto.servicio.IProfesorServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProyectoApplicationTests {
	@Autowired
	private IProfesorServicio servicioProfesor;



	@Test
	void contextLoads() {

		Profesor nuevo= new Profesor();
		nuevo.setIdProfesor(0);
		nuevo.setNombre("Fernando");
		nuevo.setApellido("Garcia");
		nuevo.setCorreo("profe@gmail.com");
		nuevo.setEspecializacion("Desarrollo web");

		servicioProfesor.insertarProfesor(nuevo);

		Profesor profesor2 = new Profesor();
		profesor2.setIdProfesor(0);
		profesor2.setNombre("Maria");
		profesor2.setApellido("Perez");
		profesor2.setCorreo("mperez@gmail.com");
		profesor2.setEspecializacion("Inteligencia Artificial");

		servicioProfesor.insertarProfesor(profesor2);

		Profesor profesor3 = new Profesor();
		profesor3.setIdProfesor(0);
		profesor3.setNombre("Luis");
		profesor3.setApellido("Torres");
		profesor3.setCorreo("luis.torres@gmail.com");
		profesor3.setEspecializacion("Bases de Datos");

		servicioProfesor.insertarProfesor(profesor3);
	}

}
