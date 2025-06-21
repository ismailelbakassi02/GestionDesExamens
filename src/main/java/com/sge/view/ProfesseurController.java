package com.sge.view;

import com.sge.model.Professeur;
import com.sge.service.ProfesseurService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@Getter
@Setter
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
        professeurs = professeurService.findAll(); // Refresh the list
        professeur = new Professeur(); // Reset the form
    }

    public void delete(Long id) {
        professeurService.delete(id);
        professeurs = professeurService.findAll(); // Refresh the list
    }
}
