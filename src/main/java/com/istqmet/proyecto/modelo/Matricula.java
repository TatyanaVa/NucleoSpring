package com.istqmet.proyecto.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="db.Matricula")
public class Matricula implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idMatricula;
    private Date fechaMatricula;

    @ManyToOne
    @JoinColumn(name = "fkMatricula")
    private Estudiante fkMatricula;

    @ManyToOne
    @JoinColumn(name = "fkMatriculaCurso")
    private Curso fkMatriculaCurso;

    @ManyToOne
    @JoinColumn(name="fkMatriculaAula")
    private Aula fkMatriculaAula;
}

