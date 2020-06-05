package com.garehn.lyceesgt.lycees;

import android.content.res.Resources;

import com.garehn.lyceesgt.R;

public enum Langues {

    ITA ("italien"),
    ESP ("espagnol"),
    ALL ("allemand"),
    CHI ("chinois"),
    POR ("portugais");

    private String name = "";





    //Constructor
    Langues(String name){
        this.name = name;

    }


    public String toString(){
        return name;
    }

}
