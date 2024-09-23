package com.istqmet.proyecto.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="db.Estudiante")
public class Estudiante implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idEstudiante;
    private  String nombreEstudiante;
    private String apellidoEstudiante;
    private Date fechaNacimiento;
    private String correo;

    //Relación un estudiante varias matriculas
    //Varios estudiantes una matricula

    @OneToMany(mappedBy = "fkMatricula")
    private List<Matricula>listaMatricula=new ArrayList<>();

}
