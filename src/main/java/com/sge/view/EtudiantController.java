package com.sge.view;

import com.sge.model.Etudiant;
import com.sge.service.EtudiantService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class EtudiantController {

    @Inject
    private EtudiantService etudiantService;

    private List<Etudiant> etudiants;
    private Etudiant etudiant = new Etudiant();

    @PostConstruct
    public void init() {
        etudiants = etudiantService.findAll();
    }

    public void save() {
        etudiantService.save(etudiant);
        etudiant = new Etudiant();
        etudiants = etudiantService.findAll();
    }

    public void update() {
        etudiantService.update(etudiant);
        etudiant = new Etudiant();
        etudiants = etudiantService.findAll();
    }

    // Getters and Setters
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
