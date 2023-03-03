package com.api.medicando.main.db.tables;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "questoes_topicos")
@IdClass(QuestaoTopicoId.class)
public class QuestaoTopico {

    @Id
    @Column(name = "id_questao")
    private int idQuestao;

    @Id
    @Column(name = "id_topico")
    private int idTopico;

    public QuestaoTopico(){}

    public QuestaoTopico(int idQuestao, int idTopico) {
        this.idQuestao = idQuestao;
        this.idTopico = idTopico;
    }

    public int getIdQuestao() {
        return idQuestao;
    }

    public int getIdTopico() {
        return idTopico;
    }
}

class QuestaoTopicoId implements Serializable {
    private int idQuestao;
    private int idTopico;
    public int getIdQuestao() {
        return idQuestao;
    }
    public int getIdTopico() {
        return idTopico;
    }
    
}