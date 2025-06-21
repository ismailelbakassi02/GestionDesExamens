package com.sge.service;

import com.sge.model.Etudiant;
import com.sge.model.Inscription;
import com.sge.model.Matiere;
import com.sge.repository.EtudiantRepository;
import com.sge.repository.InscriptionRepository;
import com.sge.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionService {

    private final InscriptionRepository inscriptionRepository;
    private final EtudiantRepository etudiantRepository;
    private final MatiereRepository matiereRepository; // Assuming MatiereRepository exists from Achraf's module

    @Autowired
    public InscriptionService(InscriptionRepository inscriptionRepository,
                              EtudiantRepository etudiantRepository,
                              MatiereRepository matiereRepository) {
        this.inscriptionRepository = inscriptionRepository;
        this.etudiantRepository = etudiantRepository;
        this.matiereRepository = matiereRepository;
    }

    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    public Optional<Inscription> getInscriptionById(Long id) {
        return inscriptionRepository.findById(id);
    }

    @Transactional
    public Inscription createInscription(Long etudiantId, Long matiereId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new RuntimeException("Etudiant not found with id " + etudiantId));
        Matiere matiere = matiereRepository.findById(matiereId)
                .orElseThrow(() -> new RuntimeException("Matiere not found with id " + matiereId));

        // Check if inscription already exists
        if (inscriptionRepository.findByEtudiantAndMatiere(etudiant, matiere).isPresent()) {
            throw new RuntimeException("Etudiant is already inscribed in this Matiere.");
        }

        Inscription inscription = new Inscription(etudiant, matiere);
        return inscriptionRepository.save(inscription);
    }

    public void deleteInscription(Long id) {
        inscriptionRepository.deleteById(id);
    }

    public List<Inscription> getInscriptionsByEtudiant(Long etudiantId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new RuntimeException("Etudiant not found with id " + etudiantId));
        return inscriptionRepository.findByEtudiant(etudiant);
    }

    public List<Inscription> getInscriptionsByMatiere(Long matiereId) {
        Matiere matiere = matiereRepository.findById(matiereId)
                .orElseThrow(() -> new RuntimeException("Matiere not found with id " + matiereId));
        return inscriptionRepository.findByMatiere(matiere);
    }
}