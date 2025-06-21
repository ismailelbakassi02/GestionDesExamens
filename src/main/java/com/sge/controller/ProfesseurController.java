package com.sge.controller;

import com.sge.model.Professeur;
import com.sge.service.ProfesseurService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ProfesseurController implements Serializable {

    @Autowired
    private ProfesseurService professeurService;

    private List<Professeur> professeurs;
    private Professeur professeur = new Professeur();

    @PostConstruct
    public void init() {
        professeurs = professeurService.findAll();
    }

    public void save() {
        professeurService.save(professeur);
        professeurs = professeurService.findAll();
        professeur = new Professeur();
    }

    public void delete(Long id) {
        professeurService.delete(id);
        professeurs = professeurService.findAll();
    }

    public void edit(Professeur selected) {
        this.professeur = selected;
    }

    // Getters & Setters
    public List<Professeur> getProfesseurs() { return professeurs; }
    public Professeur getProfesseur() { return professeur; }
    public void setProfesseur(Professeur professeur) { this.professeur = professeur; }
}