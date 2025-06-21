package com.sge.controller;

import com.sge.model.Etudiant;
import com.sge.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

@Component
@SessionScope // Or @RequestScope, depending on desired scope
public class EtudiantController implements Serializable {

    private final EtudiantService etudiantService;

    private List<Etudiant> etudiants;
    private Etudiant selectedEtudiant;
    private Etudiant newEtudiant = new Etudiant();

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @PostConstruct
    public void init() {
        loadEtudiants();
    }

    public void loadEtudiants() {
        this.etudiants = etudiantService.getAllEtudiants();
    }

    public void createEtudiant() {
        try {
            etudiantService.saveEtudiant(newEtudiant);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Étudiant ajouté avec succès."));
            newEtudiant = new Etudiant(); // Reset form
            loadEtudiants(); // Refresh list
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Erreur lors de l'ajout de l'étudiant: " + e.getMessage()));
        }
    }

    public void updateEtudiant() {
        if (selectedEtudiant != null && selectedEtudiant.getId() != null) {
            try {
                etudiantService.updateEtudiant(selectedEtudiant.getId(), selectedEtudiant);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Étudiant mis à jour avec succès."));
                loadEtudiants(); // Refresh list
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Erreur lors de la mise à jour de l'étudiant: " + e.getMessage()));
            }
        }
    }

    public void deleteEtudiant(Long id) {
        try {
            etudiantService.deleteEtudiant(id);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Étudiant supprimé avec succès."));
            loadEtudiants(); // Refresh list
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Erreur lors de la suppression de l'étudiant: " + e.getMessage()));
        }
    }

    // For PrimeFaces dialogs or editing selected row
    public void onRowSelect() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Étudiant sélectionné", selectedEtudiant.getNom() + " " + selectedEtudiant.getPrenom()));
    }

    // Getters and Setters for JSF view
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Etudiant getSelectedEtudiant() {
        return selectedEtudiant;
    }

    public void setSelectedEtudiant(Etudiant selectedEtudiant) {
        this.selectedEtudiant = selectedEtudiant;
    }

    public Etudiant getNewEtudiant() {
        return newEtudiant;
    }

    public void setNewEtudiant(Etudiant newEtudiant) {
        this.newEtudiant = newEtudiant;
    }
}