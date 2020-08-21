package com.garehn.lyceesgt.lycees;

public enum DoubleCursus {

    ESABAC ("ESABAC"),
    BACHIBAC("BACHIBAC"),
    ABIBAC("ABIBAC"),
    BIITA ("Section binationale italien"),
    BIALL ("Section binationale allemand"),
    BIESP ("Section binationale espagnol"),
    EUROALL("Section européenne allemand"),
    EUROPOR("Section européenne portugais"),
    EUROESP("Section européenne espagnol"),
    EUROANG("Section européenne anglais"),
    INTANG("Section internationale anglais");

    private String name = "";

    //Constructor
    DoubleCursus(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

}
