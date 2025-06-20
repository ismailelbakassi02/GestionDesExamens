package com.sge.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    private LocalDateTime dateExamen;
    private int duree; // in minutes
    private String typeExamen; // CC, DS, FINAL
    private String statut;
}
