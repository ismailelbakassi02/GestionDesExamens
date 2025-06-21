package com.sge.service;

import com.sge.model.Note;
import com.sge.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculService {

    @Autowired
    private NoteRepository noteRepository;

    /**
     * Calcule la moyenne des notes d'un étudiant pour toutes ses notes enregistrées.
     *
     * @param etudiantId l'id de l'étudiant
     * @return la moyenne des notes, ou null si pas de notes
     */
    public Double calculerMoyenneParEtudiant(Long etudiantId) {
        List<Note> notes = noteRepository.findByEtudiantId(etudiantId);

        if (notes == null || notes.isEmpty()) {
            return null;
        }

        double somme = 0.0;
        int count = 0;
        for (Note note : notes) {
            somme += note.getNote();
            count++;
        }

        return somme / count;
    }
}
