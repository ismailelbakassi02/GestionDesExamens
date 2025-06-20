package com.sge.service;

import com.sge.model.Professeur;
import com.sge.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesseurService {

    @Autowired
    private ProfesseurRepository repository;

    public List<Professeur> findAll() {
        return repository.findAll();
    }

    public Professeur save(Professeur professeur) {
        return repository.save(professeur);
    }
}
