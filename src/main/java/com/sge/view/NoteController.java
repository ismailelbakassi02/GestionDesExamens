package com.sge.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NoteController {
    // Controller logic will be implemented here
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
