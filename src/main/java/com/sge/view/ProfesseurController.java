package com.sge.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ProfesseurController {
    // Controller logic will be implemented here

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
