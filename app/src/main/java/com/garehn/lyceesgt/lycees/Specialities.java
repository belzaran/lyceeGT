package com.garehn.lyceesgt.lycees;

public enum Specialities {

    THEATRE ("Theâtre"),
    HDA ("Histoire des arts"),
    LITTERATURE("Littérature, langues et cultures de l'antiquité"),
    HISTOIRE ("Histoire-géographie, géopolitique et sciences politiques"),
    HUMANITES ("Humanités, littérature et philosophie"),
    LANGUES ("Langues, littératures et cultures étrangères et régionales"),
    MATHS ("Mathématiques"),
    NUMERIQUE ("Numérique et sciences informatiques"),
    PHYSIQUE ("Physique-Chimie"),
    SVT ("Sciences de la Vie et de la Terre"),
    SI ("Sciences de l'ingénieur"),
    SES ("Sciences économiques et sociales");

    private String name = "";

    //Constructor
    Specialities(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }




}
