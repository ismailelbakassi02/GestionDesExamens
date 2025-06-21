package com.sge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String intitule;
    private double coefficient;

    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private Professeur responsable;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @OneToOne(mappedBy = "module")
    private Examen examen;
}
