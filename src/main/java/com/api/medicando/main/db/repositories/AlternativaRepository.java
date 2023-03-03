package com.api.medicando.main.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.medicando.main.db.tables.Alternativa;

@Repository
public interface AlternativaRepository extends JpaRepository<Alternativa, Integer> {
    
}
