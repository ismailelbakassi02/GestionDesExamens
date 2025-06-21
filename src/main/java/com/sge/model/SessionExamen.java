package com.sge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class SessionExamen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private Date dateDebut;
    private Date dateFin;
    private String anneeAcademique;

    @OneToMany(mappedBy = "sessionExamen")
    private List<Examen> examens;
}
