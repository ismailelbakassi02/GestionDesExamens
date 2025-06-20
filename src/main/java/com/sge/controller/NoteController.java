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
    private NoteService service;

    @GetMapping
    public List<Note> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Note create(@RequestBody Note note) {
        return service.save(note);
    }
}
