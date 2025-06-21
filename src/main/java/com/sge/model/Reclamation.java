package com.sge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Reclamation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String statut;
    private Date dateCreation;
    private Date dateTraitement;
    private String reponse;

    @OneToOne
    @JoinColumn(name = "note_id", referencedColumnName = "id")
    private Note note;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
}
