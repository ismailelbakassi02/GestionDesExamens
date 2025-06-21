package com.sge.repository;

import com.sge.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByEtudiantId(Long etudiantId);
    List<Note> findByEtudiantIdAndExamen_Matiere_Id(Long etudiantId, Long matiereId);
}
