package com.sge.service;

import com.sge.model.Matiere;
import com.sge.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService {
    @Autowired
    private MatiereRepository matiereRepository;

    public List<Matiere> findAll() {
        return matiereRepository.findAll();
    }

    public Matiere save(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    public void delete(Long id) {
        matiereRepository.deleteById(id);
    }

    public Matiere findById(Long id) {
        return matiereRepository.findById(id).orElse(null);
    }
}