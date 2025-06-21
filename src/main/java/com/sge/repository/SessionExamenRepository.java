package com.sge.repository;

import com.sge.model.SessionExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionExamenRepository extends JpaRepository<SessionExamen, Long> {
}
