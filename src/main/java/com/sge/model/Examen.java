package com.sge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private int duree; // in minutes
    private String statut;

    @ManyToOne
    @JoinColumn(name = "session_examen_id")
    private SessionExamen sessionExamen;

    @OneToOne
    @JoinColumn(name = "module_id", referencedColumnName = "id")
    private Module module;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sujet_examen_id", referencedColumnName = "id")
    private SujetExamen sujetExamen;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    @ManyToMany(mappedBy = "examensSurveilles")
    private List<Professeur> surveillants;

    @OneToMany(mappedBy = "examen")
    private List<Note> notes;
}
