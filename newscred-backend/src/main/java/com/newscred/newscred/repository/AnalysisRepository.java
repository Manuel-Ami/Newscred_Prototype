package com.newscred.newscred.repository;

import com.newscred.newscred.entity.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnalysisRepository
        extends JpaRepository<Analysis, Long> {

    List<Analysis> findByUserEmail(String userEmail);

}