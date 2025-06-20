package com.sge.controller;

import com.sge.model.Professeur;
import com.sge.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurService service;

    @GetMapping
    public List<Professeur> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Professeur create(@RequestBody Professeur professeur) {
        return service.save(professeur);
    }
}
