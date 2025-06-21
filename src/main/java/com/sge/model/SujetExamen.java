package com.sge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class SujetExamen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String contenu;
    private String statut;
    private Date dateValidation;

    @ManyToOne
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;

    @OneToOne(mappedBy = "sujetExamen")
    private Examen examen;
}
