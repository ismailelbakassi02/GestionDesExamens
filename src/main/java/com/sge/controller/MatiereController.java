package com.sge.controller;

import com.sge.model.Matiere;
import com.sge.model.Professeur;
import com.sge.service.MatiereService;
import com.sge.service.ProfesseurService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class MatiereController implements Serializable {

    @Autowired
    private MatiereService matiereService;

    @Autowired
    private ProfesseurService professeurService;

    private List<Matiere> matieres;
    private List<Professeur> professeurs;
    private Matiere matiere = new Matiere();

    @PostConstruct
    public void init() {
        matieres = matiereService.findAll();
        professeurs = professeurService.findAll();
    }

    public void save() {
        matiereService.save(matiere);
        matieres = matiereService.findAll();
        matiere = new Matiere();
    }

    public void delete(Long id) {
        matiereService.delete(id);
        matieres = matiereService.findAll();
    }

    public void edit(Matiere selected) {
        this.matiere = selected;
    }

    // Getters & Setters
    public List<Matiere> getMatieres() { return matieres; }
    public Matiere getMatiere() { return matiere; }
    public void setMatiere(Matiere matiere) { this.matiere = matiere; }
    public List<Professeur> getProfesseurs() { return professeurs; }
}
