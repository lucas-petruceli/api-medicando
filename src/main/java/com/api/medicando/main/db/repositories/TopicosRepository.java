package com.api.medicando.main.db.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.medicando.main.db.dto.TopicoModulo;
import com.api.medicando.main.db.tables.Topico;

@Repository
public interface TopicosRepository extends JpaRepository<Topico, Integer> {
    List<Topico> findByModulo(int modulo);
    Topico findById(int id);
    
    // ATENÇÃO -> o nome das tabelas, tem que ser o nome da classe. (letra maiuscula) e as colunas, o nome do atributo
    @Query("SELECT new com.api.medicando.main.db.dto.TopicoModulo(t.id, t.nome, t.idPai, t.modulo, m.nome) FROM Topico t INNER JOIN Modulo m ON t.modulo = m.valor WHERE t.modulo = 2")
    List<TopicoModulo> buscarTopicosModuloDois();

    @Query("SELECT COUNT(id) FROM Topico t WHERE t.modulo = 2")
    Integer countTopicosMatricula();
}
