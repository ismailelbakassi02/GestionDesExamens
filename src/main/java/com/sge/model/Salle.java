package com.sge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private int capacite;
    private String batiment;

    @OneToMany(mappedBy = "salle")
    private List<Examen> examens;
}
