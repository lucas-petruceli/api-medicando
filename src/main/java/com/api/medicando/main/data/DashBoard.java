package com.api.medicando.main.data;

import java.io.Serializable;

public class DashBoard implements Serializable{
    private Integer qtdTopicosMatricula;
    private Integer qtdQuestoes;

    public DashBoard(Integer qtdTopicosMatricula, Integer qtdQuestoes) {
        this.qtdTopicosMatricula = qtdTopicosMatricula;
        this.qtdQuestoes = qtdQuestoes;
    }

    public Integer getQtdTopicosMatricula() {
        return qtdTopicosMatricula;
    }

    public Integer getQtdQuestoes() {
        return qtdQuestoes;
    }
    
}
