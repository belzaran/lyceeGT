package com.garehn.lyceesgt.lycees;

public enum Specialities {

    THE ("Theâtre"),
    HDA ("Histoire des arts"),
    LIT("Littérature, langues et cultures de l'antiquité"),
    HIS ("Histoire-géographie, géopolitique et sciences politiques"),
    HUM ("Humanités, littérature et philosophie"),
    LAN ("Langues, littératures et cultures étrangères et régionales"),
    MAT ("Mathématiques"),
    NUM ("Numérique et sciences informatiques"),
    PHY ("Physique-Chimie"),
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
