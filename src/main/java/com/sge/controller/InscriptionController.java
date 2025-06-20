package com.sge.controller;

import com.sge.model.Inscription;
import com.sge.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionController {

    @Autowired
    private InscriptionService service;

    @GetMapping
    public List<Inscription> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Inscription create(@RequestBody Inscription inscription) {
        return service.save(inscription);
    }
}
