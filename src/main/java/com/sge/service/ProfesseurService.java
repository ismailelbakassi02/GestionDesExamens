package com.sge.service;

import com.sge.model.Professeur;
import com.sge.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesseurService {
    @Autowired
    private ProfesseurRepository professeurRepository;

    public List<Professeur> findAll() {
        return professeurRepository.findAll();
    }

    public Professeur save(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    public void delete(Long id) {
        professeurRepository.deleteById(id);
    }

    public Professeur findById(Long id) {
        return professeurRepository.findById(id).orElse(null);
    }
}