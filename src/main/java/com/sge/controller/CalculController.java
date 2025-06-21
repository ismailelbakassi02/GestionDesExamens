package com.sge.controller;

import com.sge.service.CalculService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculs")
public class CalculController {

    @Autowired
    private CalculService calculService;

    // Endpoint pour récupérer la moyenne d'un étudiant par son ID
    @GetMapping("/moyenne/{etudiantId}")
    public ResponseEntity<Double> getMoyenneEtudiant(@PathVariable Long etudiantId) {
        Double moyenne = calculService.calculerMoyenneParEtudiant(etudiantId);
        if (moyenne == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(moyenne);
    }
}

