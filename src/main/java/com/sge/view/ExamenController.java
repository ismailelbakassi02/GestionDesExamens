package com.sge.view;

import com.sge.model.Examen;
import com.sge.service.ExamenService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class ExamenController {

    @Inject
    private ExamenService examenService;

    private List<Examen> examens;
    private Examen examen = new Examen();

    @PostConstruct
    public void init() {
        examens = examenService.findAll();
    }

    public void save() {
        examenService.save(examen);
        examen = new Examen();
        examens = examenService.findAll();
    }

    public void update() {
        examenService.update(examen);
        examen = new Examen();
        examens = examenService.findAll();
    }

    // Getters and Setters
    public List<Examen> getExamens() {
        return examens;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }
}
