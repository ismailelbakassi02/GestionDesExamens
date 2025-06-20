package com.sge.service;

import com.sge.model.Etudiant;
import com.sge.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository repository;

    public List<Etudiant> findAll() {
        return repository.findAll();
    }

    public Etudiant save(Etudiant etudiant) {
        return repository.save(etudiant);
    }
}
