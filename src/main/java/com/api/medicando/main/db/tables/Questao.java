package com.api.medicando.main.db.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "questoes")
public class Questao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String enunciado;
    
    @Column(nullable = false)
    private Integer dificuldade;
    
    @Column(nullable = false)
    private Integer modulo;
    
    @Column(nullable = false)
    private Character situacao = 'N';
    
    public Questao() {
    }
    
    public Questao(String enunciado, Integer dificuldade, Integer modulo) {
        this.enunciado = enunciado;
        this.dificuldade = dificuldade;
        this.modulo = modulo;
    }

    public Integer getId() {
        return id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Integer getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Integer dificuldade) {
        this.dificuldade = dificuldade;
    }

    public Integer getModulo() {
        return modulo;
    }

    public void setModulo(Integer modulo) {
        this.modulo = modulo;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }
}
