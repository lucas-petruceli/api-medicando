package com.api.medicando.main.data.request;

import java.util.ArrayList;
import java.util.List;

import com.api.medicando.main.db.tables.Alternativa;

public class QuestaoRequest {
    private String enunciado;    
    private int dificuldade;    
    private int modulo;
    private ArrayList<Integer> topicos;
    private List<Alternativa> alternativas;
    
    public QuestaoRequest(String enunciado, int dificuldade, int modulo, ArrayList<Integer> topicos,
            List<Alternativa> alternativas) {
        this.enunciado = enunciado;
        this.dificuldade = dificuldade;
        this.modulo = modulo;
        this.topicos = topicos;
        this.alternativas = alternativas;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public int getModulo() {
        return modulo;
    }

    public ArrayList<Integer> getTopicos() {
        return topicos;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }
    
}
