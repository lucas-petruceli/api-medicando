package com.api.medicando.main.db.dto;

public class TopicoModulo {
    private int id;
    private String nome;
    private Integer idPai;
    private int modulo;
    private String nomemodulo;

    public TopicoModulo(int id, String nome, Integer idPai, int modulo, String nomemodulo) {
        this.id = id;
        this.nome = nome;
        this.idPai = idPai;
        this.modulo = modulo;
        this.nomemodulo = nomemodulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdPai() {
        return idPai;
    }

    public void setIdPai(Integer id_pai) {
        this.idPai = id_pai;
    }

    public int getModulo() {
        return modulo;
    }

    public void setModulo(int modulo) {
        this.modulo = modulo;
    }

    public String getNomemodulo() {
        return nomemodulo;
    }

    public void setNomemodulo(String nomeModulo) {
        this.nomemodulo = nomeModulo;
    }
}

