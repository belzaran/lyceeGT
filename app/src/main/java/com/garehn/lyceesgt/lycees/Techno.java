package com.garehn.lyceesgt.lycees;

public enum Techno {

    STD2A ("STD2A"),
    STMG ("STMG"),
    STI2D ("STI2D"),
    STL ("STL");

    private String name = "";

    //Constructor
    Techno(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

}
