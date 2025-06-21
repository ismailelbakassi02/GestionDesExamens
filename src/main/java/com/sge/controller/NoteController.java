package com.sge.controller;

import com.sge.model.Note;
import com.sge.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping
    public Note add(@RequestBody Note note) {
        return noteService.saisirNote(note);
    }

    @GetMapping("/etudiant/{id}")
    public List<Note> getByEtudiant(@PathVariable Long id) {
        return noteService.getNotesByEtudiant(id);
    }
}