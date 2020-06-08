package com.garehn.lyceesgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.garehn.lyceesgt.lycees.Lycee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ResultActivity extends AppCompatActivity {

    static public int maxLycees;
    public Lycee[] lycees;
    private static final int GAME_ACTIVITY_REQUEST_CODE = 69;
    public String[] SCORE;

    public ArrayList<Integer[]> rankingLycees = new ArrayList<Integer[]>();

    private ProgressBar[] resultBar = new ProgressBar[6];
    private TextView[] resultText = new TextView[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        createAssets();

        // TAKE THE RESULTS OF THE LEVEL ACTIVITY (FIRST LINE OF THE TABLE)
        Intent intent = getIntent();
        maxLycees = intent.getIntExtra("max", 0);
        lycees = new Lycee[maxLycees];
        SCORE = new String[maxLycees];
        SCORE[0]="HUGO";
        SCORE[1]="CHARLEMAGNE";
        SCORE[2]="GERMAIN";
        SCORE[3]="ARAGO";
        SCORE[4]="BOUCHER";
        SCORE[5]="RAVEL";

        if (intent != null) {
            for (int i = 0; i < maxLycees; i++) {
                lycees[i] = intent.getParcelableExtra(SCORE[i]);
            }
        }

        sortLycees(maxLycees);

    }

    public void createAssets(){
        resultText[0] = findViewById(R.id.result_text_l1);
        resultText[1] = findViewById(R.id.result_text_l2);
        resultText[2] = findViewById(R.id.result_text_l3);
        resultText[3] = findViewById(R.id.result_text_l4);
        resultText[4] = findViewById(R.id.result_text_l5);
        resultText[5] = findViewById(R.id.result_text_l6);
        resultBar[0] = findViewById(R.id.result_bar_l1);
        resultBar[1] = findViewById(R.id.result_bar_l2);
        resultBar[2] = findViewById(R.id.result_bar_l3);
        resultBar[3] = findViewById(R.id.result_bar_l4);
        resultBar[4] = findViewById(R.id.result_bar_l5);
        resultBar[5] = findViewById(R.id.result_bar_l6);
        //LayerDrawable layerDrawable = (LayerDrawable) resultBar[0].getProgressDrawable();
        //Drawable progressDrawable = layerDrawable.findDrawableByLayerId(android.R.id.progress);
        //progressDrawable.setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);

    }

    public static String colorDecToHex(int p_red, int p_green, int p_blue)
    {
        String red = Integer.toHexString(p_red);
        String green = Integer.toHexString(p_green);
        String blue = Integer.toHexString(p_blue);

        if (red.length() == 1)
        {
            red = "0" + red;
        }
        if (green.length() == 1)
        {
            green = "0" + green;
        }
        if (blue.length() == 1)
        {
            blue = "0" + blue;
        }

        String colorHex = "#" + red + green + blue;
        return colorHex;
    }


    public void sortLycees(int nb){

        // nb = number of values to sort

        int max = 0;
        int[] key = new int[nb];

        boolean chosen = false;

        for(int i = 0;i<nb;i++) {
            max = 0;

            for (int j = 0; j < nb; j++) {
                if (lycees[j].getPoints() > max) {

                    if (i==0){
                        key[i] = j;
                        max = (int) lycees[j].getPoints();
                    }

                    else {
                        chosen = false;
                        for (int k = 0; k < i; k++) {
                            if (j == key[k]) {
                                chosen = true;
                            }
                        }
                        if(chosen == false){
                            key[i] = j;
                            max = (int) lycees[j].getPoints();
                        }
                    }
                }
                else if (lycees[j].getPoints() == max){
                    if (i==0){
                        key[i] = j;
                        max = (int) lycees[j].getPoints();
                    }

                    else {
                        chosen = false;
                        for (int k = 0; k < i; k++) {
                            if (j == key[k]) {
                                chosen = true;
                            }
                        }
                        if(chosen == false){
                            key[i] = j;
                            max = (int) lycees[j].getPoints();
                        }
                    }


                }
            }
        }

        //find the maximum of points
        int finalMax = 0;

        for(int i = 0;i<maxLycees;i++) {
            if (lycees[i].getPoints() > finalMax) {
                finalMax = lycees[i].getPoints();
            }
        }

        //set the progressBars to the max points
        for(int i = 0;i<maxLycees;i++){
            resultBar[i].setMax(finalMax);
        }


        for(int i = 0; i<maxLycees; i++){
            resultBar[i].setProgress((int)lycees[key[i]].getPoints());
            resultText[i].setText(i+1 + " - " + lycees[key[i]].getName());
            drawProgressBar(resultBar[i], lycees[key[i]].getPoints(), finalMax);
            //LayerDrawable layerDrawable = (LayerDrawable) resultBar[i].getProgressDrawable();
            //Drawable progressDrawable = layerDrawable.findDrawableByLayerId(android.R.id.progress);
            //progressDrawable.setColorFilter(Color.argb(150, 50, 200, 50), PorterDuff.Mode.SRC_IN);
        }

    }

    public void drawProgressBar(ProgressBar bar, int points, int max){

        int colorGreen = Color.argb(200,144, 217, 43);
        int colorYellow = Color.argb(200,217, 211, 43);
        int colorOrange = Color.argb(200,217, 180, 54);
        int colorRed = Color.argb(200,217, 100, 54);

        LayerDrawable layerDrawable = (LayerDrawable) bar.getProgressDrawable();
        Drawable progressDrawable = layerDrawable.findDrawableByLayerId(android.R.id.progress);
        float result = (float)points/max;
        Log.i("GAREHN_RESULT","Calcul : " + points + " / " + max + " = " + result );

        if(result>0.75){
            progressDrawable.setColorFilter(colorGreen, PorterDuff.Mode.SRC_IN);
        }
        else if(result>0.5){
            progressDrawable.setColorFilter(colorYellow, PorterDuff.Mode.SRC_IN);
        }
        else if(result>0.25){
            progressDrawable.setColorFilter(colorOrange, PorterDuff.Mode.SRC_IN);
        }
        else{
                progressDrawable.setColorFilter(colorRed, PorterDuff.Mode.SRC_IN);
        }


        //progressDrawable.setColorFilter(Color.argb(150, 50, 200, 50), PorterDuff.Mode.SRC_IN);
        //progressDrawable.setColorFilter(colorGreen, PorterDuff.Mode.SRC_IN);

    }


    /*public void showScores(){

        //find the maximum of points
        int max = 0;

        for(int i = 0;i<maxLycees;i++) {
            if (lycees[i].getPoints() > max) {
                max = lycees[i].getPoints();
            }
        }

        //set the progressBars to the max points
        for(int i = 0;i<maxLycees;i++){
            resultBar[i].setMax(max);
        }


        for(int i = 0;i<maxLycees;i++){
            resultText[i].setText(lycees[i].getName());
            resultBar[i].setProgress(lycees[i].getPoints());
            //Drawable bgDrawable = resultBar[i].getProgressDrawable();
            //bgDrawable.setColorFilter(Color.GREEN, android.graphics.PorterDuff.Mode.MULTIPLY);
            //resultBar[i].setProgressDrawable(bgDrawable);


        }

    }*/



}