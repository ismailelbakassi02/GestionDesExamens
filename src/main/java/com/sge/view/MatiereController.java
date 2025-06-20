package com.sge.view;

import com.sge.model.Matiere;
import com.sge.service.MatiereService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class MatiereController {

    @Inject
    private MatiereService matiereService;

    private List<Matiere> matieres;
    private Matiere matiere = new Matiere();
    private Long professeurId;

    @PostConstruct
    public void init() {
        matieres = matiereService.findAll();
    }

    public void save() {
        matiereService.save(matiere);
        matiere = new Matiere();
        matieres = matiereService.findAll();
    }

    public void assign() {
        // Business logic to assign matiere to professeur
    }

    // Getters and Setters
    public List<Matiere> getMatieres() {
        return matieres;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Long getProfesseurId() {
        return professeurId;
    }

    public void setProfesseurId(Long professeurId) {
        this.professeurId = professeurId;
    }
}
