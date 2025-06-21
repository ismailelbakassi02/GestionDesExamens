package com.sge.service;

import com.sge.model.Examen;
import com.sge.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ExamenService {

    @Autowired
    private ExamenRepository examenRepository;

    public List<Examen> getAllExamens() {
        return examenRepository.findAll();
    }

    public Examen getExamenById(Long id) {
        return examenRepository.findById(id).orElse(null);
    }

    public Examen saveExamen(Examen examen) {
        return examenRepository.save(examen);
    }

    public void deleteExamen(Long id) {
        examenRepository.deleteById(id);
    }

    public String verifierStatut(Long examenId) {
        Examen examen = getExamenById(examenId);
        if (examen == null) return "Inconnu";

        if (LocalDateTime.now().isAfter(examen.getDateExamen())) {
            return "Terminé";
        } else {
            return "À venir";
        }
    }

    public List<String> genererListePresence(Long examenId) {
        Examen examen = getExamenById(examenId);
        if (examen == null || examen.getNotes() == null) return List.of();

        return examen.getNotes().stream()
                .map(note -> note.getEtudiant().getNom() + " " + note.getEtudiant().getPrenom())
                .toList();
    }
}

