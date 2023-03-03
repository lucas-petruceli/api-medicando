package com.api.medicando.main.db.repositories;

import org.springframework.stereotype.Repository;

import com.api.medicando.main.db.tables.Questao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface QuestoesRepository extends JpaRepository<Questao, Integer> {
    List<Questao> findBySituacao(Character situacao);

    @Query("SELECT COUNT(id) FROM Questao")
    Integer countQuestoes();
}
