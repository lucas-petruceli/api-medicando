package com.api.medicando.main.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.medicando.main.db.tables.QuestaoAlternativa;

@Repository
public interface QuestoesAlternativasRepository extends JpaRepository<QuestaoAlternativa, Integer> {
    
}
