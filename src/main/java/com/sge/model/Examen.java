package com.sge.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Examen {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private LocalDateTime dateExamen;
    private int duree;
    private String statut;

    @ManyToOne
    private Matiere matiere;

    @OneToMany(mappedBy = "examen")
    private List<Note> notes;


}
