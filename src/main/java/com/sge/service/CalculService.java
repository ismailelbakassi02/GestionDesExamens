package com.sge.service;

import com.sge.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculService {

    public double calculateAverage(List<Note> notes) {
        if (notes == null || notes.isEmpty()) {
            return 0.0;
        }
        return notes.stream().mapToDouble(Note::getNote).average().orElse(0.0);
    }
}
