package com.api.medicando.main.db.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "topicos")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @Column(name = "id_pai")
    private Integer idPai;
    private int modulo;

    
    public Topico(String nome, Integer idPai, int modulo) {
        this.nome = nome;
        this.idPai = idPai;
        this.modulo = modulo;
    }

    public Topico(){}

    public int getId() {
        return id;
    }
    public Integer getIdPai() {
        return idPai;
    }

    public void setIdPai(Integer idPai) {
        this.idPai = idPai;
    }

    public String getNome() {
        return nome;
    }

    public int getModulo() {
        return modulo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setModulo(int modulo) {
        this.modulo = modulo;
    }
    
}
