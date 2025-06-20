package com.sge.view;

import com.sge.model.Professeur;
import com.sge.service.ProfesseurService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class ProfesseurController {

    @Inject
    private ProfesseurService professeurService;

    private List<Professeur> professeurs;
    private Professeur professeur = new Professeur();

    @PostConstruct
    public void init() {
        professeurs = professeurService.findAll();
    }

    public void save() {
        professeurService.save(professeur);
        professeur = new Professeur();
        professeurs = professeurService.findAll();
    }

    public void update() {
        professeurService.update(professeur);
        professeur = new Professeur();
        professeurs = professeurService.findAll();
    }

    public void delete(Long id) {
        professeurService.delete(id);
        professeurs = professeurService.findAll();
    }

    // Getters and Setters
    public List<Professeur> getProfesseurs() {
        return professeurs;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
}
