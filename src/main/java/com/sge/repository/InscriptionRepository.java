package com.sge.repository;

import com.sge.model.Etudiant;
import com.sge.model.Inscription;
import com.sge.model.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    List<Inscription> findByEtudiant(Etudiant etudiant);
    List<Inscription> findByMatiere(Matiere matiere);
    Optional<Inscription> findByEtudiantAndMatiere(Etudiant etudiant, Matiere matiere);
}