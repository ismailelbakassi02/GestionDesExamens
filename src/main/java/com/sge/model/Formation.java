package com.sge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String intitule;
    private String niveau;

    @OneToMany(mappedBy = "formation", cascade = CascadeType.ALL)
    private List<Module> modules;

    @OneToMany(mappedBy = "formation")
    private List<Etudiant> etudiants;
}
