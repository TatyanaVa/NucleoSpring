package com.istqmet.proyecto.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="db.Curso")
public class Curso implements Serializable{
    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idCurso;
    @Column(name = "nombreCurso",length = 50)
    private String nombreCurso;
    private String descripcion;
    private int creditos;

    @OneToMany(mappedBy = "fkMatriculaCurso")
    private List<Matricula> listaMatricula=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="fkProfeCurso")
    private Profesor fkProfesorCurso;

}
