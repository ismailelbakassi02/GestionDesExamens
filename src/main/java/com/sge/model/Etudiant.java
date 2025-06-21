package com.sge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Etudiant extends Personne {

    private String numeroEtudiant;
    private String groupe;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @OneToMany(mappedBy = "etudiant")
    private List<Note> notes;

    @OneToMany(mappedBy = "etudiant")
    private List<Reclamation> reclamations;
}
