package com.sge.controller;

import com.sge.model.Etudiant;
import com.sge.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService service;

    @GetMapping
    public List<Etudiant> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Etudiant create(@RequestBody Etudiant etudiant) {
        return service.save(etudiant);
    }
}
