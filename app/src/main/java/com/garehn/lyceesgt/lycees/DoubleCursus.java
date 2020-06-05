package com.garehn.lyceesgt.lycees;

public enum DoubleCursus {

    ESABAC ("ESABAC"),
    BACHIBAC("BACHIBAC"),
    ABIBAC("ABIBAC");

    private String name = "";

    //Constructor
    DoubleCursus(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

}
