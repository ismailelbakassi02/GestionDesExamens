package com.sge.view;

import com.sge.model.Note;
<<<<<<< HEAD

import javax.enterprise.context.RequestScoped;
=======
import com.sge.service.NoteService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
>>>>>>> 8ecbe6009a04f5d74624a17d461e3aa0b0cd7da1
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
<<<<<<< HEAD
@RequestScoped
public class NoteController {
    // Controller logic will be implemented here
        return note;n -b
=======
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
>>>>>>> 8ecbe6009a04f5d74624a17d461e3aa0b0cd7da1
    }

    public void save() {
        noteService.save(note);
        notes = noteService.findAll(); // Refresh the list
        note = new Note(); // Reset the form
    }
}
