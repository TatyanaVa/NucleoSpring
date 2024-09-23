package com.istqmet.proyecto.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@Table(name="db.Aula")
public class Aula implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idAula;
    @Column(name="nombreAula",length = 50)
    private String nombreAula;
    private  int capacidad;

    @OneToMany(mappedBy ="fkMatriculaAula" )
    private List<Matricula> listaMatricula=new ArrayList<>();

}
