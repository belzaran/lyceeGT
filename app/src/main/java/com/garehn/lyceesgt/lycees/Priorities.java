package com.garehn.lyceesgt.lycees;

import android.content.res.Resources;
import com.garehn.lyceesgt.R;

public enum Priorities {

    SIZ ("Taille du lycée"),
    RAN ("Rang du lycée"),
    DIS ("Distance du lycée par rapport à chez toi"),
    SPE ("Spécialités disponibles"),
    LAN ("Langues vivantes et options linguistiques disponibles"),
    TEC ("Bac technologiques disponibles en 1ère");

    private String name = "";

    //Constructor
    Priorities(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

}