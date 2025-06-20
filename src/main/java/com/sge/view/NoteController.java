package com.sge.view;

import com.sge.model.Note;
import com.sge.service.NoteService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class NoteController {

    @Inject
    private NoteService noteService;

    private List<Note> notes;
    private Note note = new Note();

    @PostConstruct
    public void init() {
        notes = noteService.findAll();
    }

    public void save() {
        noteService.save(note);
        note = new Note();
        notes = noteService.findAll();
    }

    // Getters and Setters
    public List<Note> getNotes() {
        return notes;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
