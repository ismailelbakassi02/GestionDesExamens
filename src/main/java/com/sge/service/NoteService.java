package com.sge.service;

import com.sge.model.Note;
import com.sge.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository repository;

    public List<Note> findAll() {
        return repository.findAll();
    }

    public Note save(Note note) {
        return repository.save(note);
    }
}
