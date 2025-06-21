package com.sge.repository;

import com.sge.model.SujetExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SujetExamenRepository extends JpaRepository<SujetExamen, Long> {
}
