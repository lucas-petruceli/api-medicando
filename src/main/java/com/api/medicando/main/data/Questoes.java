package com.api.medicando.main.data;

public class Questoes {
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
