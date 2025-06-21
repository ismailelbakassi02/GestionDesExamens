package com.sge.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Professeur {
    @Id @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String specialite;

    @OneToMany(mappedBy = "professeur", cascade = CascadeType.ALL)
    private List<Matiere> matieres = new ArrayList<>();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }
    public List<Matiere> getMatieres() { return matieres; }
    public void setMatieres(List<Matiere> matieres) { this.matieres = matieres; }
}