package com.sge.model;

import jakarta.persistence.*;

@Entity
public class Matiere {
    @Id @GeneratedValue
    private Long id;
    private String nom;
    private String code;
    private int coefficient;

    @ManyToOne
    private Professeur professeur;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public int getCoefficient() { return coefficient; }
    public void setCoefficient(int coefficient) { this.coefficient = coefficient; }
    public Professeur getProfesseur() { return professeur; }
    public void setProfesseur(Professeur professeur) { this.professeur = professeur; }
}