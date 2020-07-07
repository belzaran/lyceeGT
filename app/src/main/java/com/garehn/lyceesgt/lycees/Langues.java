package com.garehn.lyceesgt.lycees;

public enum Langues {

    ITA ("italien"),
    ESP ("espagnol"),
    ALL ("allemand"),
    CHI ("chinois"),
    POR ("portugais"),
    RUS("russe"),
    SUD("suédois"),
    ARA("arabe"),
    JAP("japonais");

    private String name = "";

    //Constructor
    Langues(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

}
