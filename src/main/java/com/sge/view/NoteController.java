package com.sge.view;

import com.sge.model.Note;
import com.sge.service.NoteService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@Getter
@Setter
public class NoteController implements Serializable {

    @Autowired
    private NoteService noteService;

    private List<Note> notes;
    private Note note = new Note();

    @PostConstruct
    public void init() {
        notes = noteService.findAll();
    }

    public void save() {
        noteService.save(note);
        notes = noteService.findAll(); // Refresh the list
        note = new Note(); // Reset the form
    }
}
