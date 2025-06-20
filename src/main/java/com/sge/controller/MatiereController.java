package com.sge.controller;

import com.sge.model.Matiere;
import com.sge.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matieres")
public class MatiereController {

    @Autowired
    private MatiereService service;

    @GetMapping
    public List<Matiere> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Matiere create(@RequestBody Matiere matiere) {
        return service.save(matiere);
    }
}
