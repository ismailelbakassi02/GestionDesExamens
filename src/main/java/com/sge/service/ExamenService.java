package com.sge.service;

import com.sge.model.Examen;
import com.sge.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenService {

    @Autowired
    private ExamenRepository repository;

    public List<Examen> findAll() {
        return repository.findAll();
    }

    public Examen save(Examen examen) {
        return repository.save(examen);
    }
}
