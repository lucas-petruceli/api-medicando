package com.api.medicando.main.db.tables;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "questoes_alternativas")
@IdClass(QuestaoAlternativaId.class)
public class QuestaoAlternativa {
    @Id
    @Column(name = "id_questao")
    private int idQuestao;

    @Id
    @Column(name = "id_alternativa")
    private int idAlternativa;

    public QuestaoAlternativa() {}

    public QuestaoAlternativa(int idQuestao, int idAlternativa) {
        this.idQuestao = idQuestao;
        this.idAlternativa = idAlternativa;
    }

    public int getIdQuestao() {
        return idQuestao;
    }

    public int getIdAlternativa() {
        return idAlternativa;
    }
}

class QuestaoAlternativaId implements Serializable{
    private int idQuestao;
    private int idAlternativa;
    public int getIdQuestao() {
        return idQuestao;
    }
    public int getIdAlternativa() {
        return idAlternativa;
    }
}
