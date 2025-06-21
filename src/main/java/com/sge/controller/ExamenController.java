package com.sge.controller;

import com.sge.model.Examen;
import com.sge.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/examens")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @GetMapping
    public List<Examen> getAll() {
        return examenService.getAllExamens();
    }

    @GetMapping("/{id}")
    public Examen getOne(@PathVariable Long id) {
        return examenService.getExamenById(id);
    }

    @PostMapping
    public Examen create(@RequestBody Examen examen) {
        return examenService.saveExamen(examen);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        examenService.deleteExamen(id);
    }

    @GetMapping("/{id}/statut")
    public String statut(@PathVariable Long id) {
        return examenService.verifierStatut(id);
    }

    @GetMapping("/{id}/presence")
    public List<String> listePresence(@PathVariable Long id) {
        return examenService.genererListePresence(id);
    }
}
