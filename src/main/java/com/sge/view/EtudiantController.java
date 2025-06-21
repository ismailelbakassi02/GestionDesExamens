package com.sge.view;

import com.sge.model.Etudiant;
import com.sge.service.EtudiantService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@Getter
@Setter
public class EtudiantController implements Serializable {

    @Autowired
    private EtudiantService etudiantService;

    private List<Etudiant> etudiants;
    private Etudiant etudiant = new Etudiant();

    @PostConstruct
    public void init() {
        etudiants = etudiantService.findAll();
    }

    public void save() {
        etudiantService.save(etudiant);
        etudiants = etudiantService.findAll(); // Refresh the list
        etudiant = new Etudiant(); // Reset the form
    }
}
