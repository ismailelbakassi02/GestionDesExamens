package com.sge.service;

import com.sge.model.Note;
import com.sge.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public Note saisirNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getNotesByEtudiant(Long etudiantId) {
        return noteRepository.findByEtudiantId(etudiantId);
    }

    public double calculerMoyenne(Long etudiantId, Long matiereId) {
        List<Note> notes = noteRepository.findByEtudiantIdAndExamen_Matiere_Id(etudiantId, matiereId);
        return notes.stream().mapToDouble(Note::getNote).average().orElse(0.0);
    }
}
