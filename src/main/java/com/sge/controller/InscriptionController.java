package com.sge.controller;

import com.sge.model.Etudiant;
import com.sge.model.Inscription;
import com.sge.model.Matiere;
import com.sge.service.EtudiantService;
import com.sge.service.InscriptionService;
import com.sge.service.MatiereService; // Assuming MatiereService exists
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

@Component
@SessionScope
public class InscriptionController implements Serializable {

    private final InscriptionService inscriptionService;
    private final EtudiantService etudiantService;
    private final MatiereService matiereService; // Assuming this service is available

    private List<Inscription> inscriptions;
    private List<Etudiant> etudiants; // For dropdown selection
    private List<Matiere> matieres;   // For dropdown selection

    private Long selectedEtudiantId;
    private Long selectedMatiereId;
    private Inscription selectedInscription;

    @Autowired
    public InscriptionController(InscriptionService inscriptionService,
                                 EtudiantService etudiantService,
                                 MatiereService matiereService) {
        this.inscriptionService = inscriptionService;
        this.etudiantService = etudiantService;
        this.matiereService = matiereService;
    }

    @PostConstruct
    public void init() {
        loadInscriptions();
        loadEtudiants();
        loadMatieres();
    }

    public void loadInscriptions() {
        this.inscriptions = inscriptionService.getAllInscriptions();
    }

    public void loadEtudiants() {
        this.etudiants = etudiantService.getAllEtudiants();
    }

    public void loadMatieres() {
        this.matieres = matiereService.getAllMatieres(); // Call method from MatiereService
    }

    public void createInscription() {
        try {
            inscriptionService.createInscription(selectedEtudiantId, selectedMatiereId);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Inscription créée avec succès."));
            // Reset selections
            selectedEtudiantId = null;
            selectedMatiereId = null;
            loadInscriptions(); // Refresh list
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Erreur lors de la création de l'inscription: " + e.getMessage()));
        }
    }

    public void deleteInscription(Long id) {
        try {
            inscriptionService.deleteInscription(id);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Inscription supprimée avec succès."));
            loadInscriptions(); // Refresh list
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Erreur lors de la suppression de l'inscription: " + e.getMessage()));
        }
    }

    // Getters and Setters for JSF view
    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public List<Matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }

    public Long getSelectedEtudiantId() {
        return selectedEtudiantId;
    }

    public void setSelectedEtudiantId(Long selectedEtudiantId) {
        this.selectedEtudiantId = selectedEtudiantId;
    }

    public Long getSelectedMatiereId() {
        return selectedMatiereId;
    }

    public void setSelectedMatiereId(Long selectedMatiereId) {
        this.selectedMatiereId = selectedMatiereId;
    }

    public Inscription getSelectedInscription() {
        return selectedInscription;
    }

    public void setSelectedInscription(Inscription selectedInscription) {
        this.selectedInscription = selectedInscription;
    }
}