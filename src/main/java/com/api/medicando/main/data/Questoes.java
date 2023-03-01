package com.api.medicando.main.data;

import java.io.Serializable;

public class Questoes implements Serializable{
    private final long serialVersionUID = 1L;

    private final long id;
    private final String title;

    public Questoes(long id, String title){
        this.id = id;
        this.title = title;
    }

    public long getId(){
        return id;
    }

    public String gettitle(){
        return title;
    }
}
