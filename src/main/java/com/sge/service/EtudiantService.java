package com.sge.service;

import com.sge.model.Etudiant;
import com.sge.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Autowired
    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Optional<Etudiant> getEtudiantById(Long id) {
        return etudiantRepository.findById(id);
    }

    public Etudiant saveEtudiant(Etudiant etudiant) {
        // Basic validation or business logic can be added here
        return etudiantRepository.save(etudiant);
    }

    @Transactional
    public Etudiant updateEtudiant(Long id, Etudiant etudiantDetails) {
        return etudiantRepository.findById(id).map(etudiant -> {
            etudiant.setNom(etudiantDetails.getNom());
            etudiant.setPrenom(etudiantDetails.getPrenom());
            etudiant.setEmail(etudiantDetails.getEmail());
            etudiant.setCne(etudiantDetails.getCne());
            etudiant.setFiliere(etudiantDetails.getFiliere());
            return etudiantRepository.save(etudiant);
        }).orElseThrow(() -> new RuntimeException("Etudiant not found with id " + id));
    }

    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    public Optional<Etudiant> getEtudiantByCne(String cne) {
        return etudiantRepository.findByCne(cne);
    }

    public Optional<Etudiant> getEtudiantByEmail(String email) {
        return etudiantRepository.findByEmail(email);
    }
}