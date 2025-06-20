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
    private ExamenService service;

    @GetMapping
    public List<Examen> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Examen create(@RequestBody Examen examen) {
        return service.save(examen);
    }
}
