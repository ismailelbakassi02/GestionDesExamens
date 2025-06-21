package com.sge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Professeur extends Personne {

    private String specialite;
    private String bureau;

    @OneToMany(mappedBy = "professeur")
    private List<SujetExamen> sujetExamens;

    @ManyToMany
    @JoinTable(
            name = "surveillance",
            joinColumns = @JoinColumn(name = "professeur_id"),
            inverseJoinColumns = @JoinColumn(name = "examen_id")
    )
    private List<Examen> examensSurveilles;
}