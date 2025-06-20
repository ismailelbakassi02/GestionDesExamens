package com.sge.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String code;
    private int coefficient;

    @ManyToOne
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;
}
