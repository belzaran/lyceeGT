package com.garehn.lyceesgt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
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
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.garehn.lyceesgt.assets.ResultDialog;
import com.garehn.lyceesgt.lycees.Lycee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    static public int maxLycees;
    public Lycee[] lycees;
    private static final int GAME_ACTIVITY_REQUEST_CODE = 69;
    public String[] SCORE;
    public String priority;




    public ArrayList<Integer[]> rankingLycees = new ArrayList<Integer[]>();

    private String LYCEE_LABEL = "Rang : %s\n%s élèves\nDistance : %s m\n\n" +
            "Langues vivantes : %s\nSpécialités : %s\n Bac techno : %s";

    private ProgressBar[] resultBar = new ProgressBar[6];
    private TextView[] resultText = new TextView[6];
    private Button buttonRestart;

    // Dialog
    private TextView dialogTextTitle;
    private TextView dialogText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        createAssets();

        Intent intent = getIntent();
        if (intent != null) {
            priority = intent.getStringExtra("priority");
            maxLycees = intent.getIntExtra("max", 0);

            lycees = new Lycee[maxLycees];
            SCORE = new String[maxLycees];
            SCORE[0] = "HUGO";
            SCORE[1] = "CHARLEMAGNE";
            SCORE[2] = "GERMAIN";
            SCORE[3] = "ARAGO";
            SCORE[4] = "BOUCHER";
            SCORE[5] = "RAVEL";
            for (int i = 0; i < maxLycees; i++) {
                lycees[i] = intent.getParcelableExtra(SCORE[i]);
            }
        }

        sortLycees(maxLycees);

    }

    public void createAssets() {
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

        buttonRestart = findViewById(R.id.result_button);
        buttonRestart.setOnClickListener(this);
        //LayerDrawable layerDrawable = (LayerDrawable) resultBar[0].getProgressDrawable();
        //Drawable progressDrawable = layerDrawable.findDrawableByLayerId(android.R.id.progress);
        //progressDrawable.setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
    }

    public static String colorDecToHex(int p_red, int p_green, int p_blue) {
        String red = Integer.toHexString(p_red);
        String green = Integer.toHexString(p_green);
        String blue = Integer.toHexString(p_blue);

        if (red.length() == 1) {
            red = "0" + red;
        }
        if (green.length() == 1) {
            green = "0" + green;
        }
        if (blue.length() == 1) {
            blue = "0" + blue;
        }

        String colorHex = "#" + red + green + blue;
        return colorHex;
    }

    public void sortLycees(int nb) {

        // nb = number of values to sort

        int max = 0;
        int[] key = new int[nb];

        boolean chosen = false;

        for (int i = 0; i < nb; i++) {
            max = 0;

            for (int j = 0; j < nb; j++) {
                if (lycees[j].getPoints() > max) {

                    if (i == 0) {
                        key[i] = j;
                        max = (int) lycees[j].getPoints();
                    } else {
                        chosen = false;
                        for (int k = 0; k < i; k++) {
                            if (j == key[k]) {
                                chosen = true;
                            }
                        }
                        if (chosen == false) {
                            key[i] = j;
                            max = (int) lycees[j].getPoints();
                        }
                    }
                } else if (lycees[j].getPoints() == max) {
                    if (i == 0) {
                        key[i] = j;
                        max = (int) lycees[j].getPoints();
                    } else {
                        chosen = false;
                        for (int k = 0; k < i; k++) {
                            if (j == key[k]) {
                                chosen = true;
                            }
                        }
                        if (chosen == false) {
                            key[i] = j;
                            max = (int) lycees[j].getPoints();
                        }
                    }


                }
            }
        }

        //find the maximum of points
        int finalMax = 0;

        for (int i = 0; i < maxLycees; i++) {
            if (lycees[i].getPoints() > finalMax) {
                finalMax = lycees[i].getPoints();
            }
        }

        //set the progressBars to the max points
        for (int i = 0; i < maxLycees; i++) {
            resultBar[i].setMax(finalMax);
        }


        for (int i = 0; i < maxLycees; i++) {
            resultBar[i].setProgress((int) lycees[key[i]].getPoints());
            lycees[key[i]].setResultRank(i);
            resultText[i].setText(i + 1 + " - " + lycees[key[i]].getName());
            drawProgressBar(resultBar[i], lycees[key[i]].getPoints(), finalMax);
            //LayerDrawable layerDrawable = (LayerDrawable) resultBar[i].getProgressDrawable();
            //Drawable progressDrawable = layerDrawable.findDrawableByLayerId(android.R.id.progress);
            //progressDrawable.setColorFilter(Color.argb(150, 50, 200, 50), PorterDuff.Mode.SRC_IN);
        }

    }

    public void drawProgressBar(ProgressBar bar, int points, int max) {

        int colorGreen = Color.argb(255, 95, 140, 30);
        int colorYellow = Color.argb(255, 145, 180, 45);
        int colorOrange = Color.argb(255, 200, 125, 45);
        int colorRed = Color.argb(255, 200, 45, 45);

        LayerDrawable layerDrawable = (LayerDrawable) bar.getProgressDrawable();
        Drawable progressDrawable = layerDrawable.findDrawableByLayerId(android.R.id.progress);
        float result = (float) points / max;
        Log.i("GAREHN_RESULT", "Calcul : " + points + " / " + max + " = " + result);

        if (result > 0.75) {
            progressDrawable.setColorFilter(colorGreen, PorterDuff.Mode.SRC_IN);
        } else if (result > 0.5) {
            progressDrawable.setColorFilter(colorYellow, PorterDuff.Mode.SRC_IN);
        } else if (result > 0.25) {
            progressDrawable.setColorFilter(colorOrange, PorterDuff.Mode.SRC_IN);
        } else {
            progressDrawable.setColorFilter(colorRed, PorterDuff.Mode.SRC_IN);
        }

        //The ResultBar need to be larger
        bar.setScaleY(2f);

    }

    @Override
    public void onClick(View v) {
        //Intent activity = new Intent(ResultActivity.this, MainActivity.class);
        //startActivityForResult(activity, GAME_ACTIVITY_REQUEST_CODE);

        /*if(v == resultText[0]){
            for(int i = 0; i< maxLycees; i++){
                if(lycees[i].getResultRank() == 0)
                    displayLycee(this, lycees[i]);
            }
        }

        else if(v == resultText[1]){
            for(int i = 0; i< maxLycees; i++){
                if(lycees[i].getResultRank() == 1)
                    displayLycee(this, lycees[i]);
            }
        }

        else if(v == resultText[2]){
            for(int i = 0; i< maxLycees; i++){
                if(lycees[i].getResultRank() == 2)
                    displayLycee(this, lycees[i]);
            }
        }

        else if(v == resultText[3]){
            for(int i = 0; i< maxLycees; i++){
                if(lycees[i].getResultRank() == 3)
                    displayLycee(this, lycees[i]);
            }
        }

        else if(v == resultText[4]){
            for(int i = 0; i< maxLycees; i++){
                if(lycees[i].getResultRank() == 4)
                    displayLycee(this, lycees[i]);
            }
        }*/
        for(int j =0;j<maxLycees;j++) {
            if (v == resultText[j]) {
                for (int i = 0; i < maxLycees; i++) {
                    if (lycees[i].getResultRank() == j)
                        displayLycee(this, lycees[i]);
                }
            }
        }




    }

    /*public void displayLycee(Activity v, Lycee lycee){
        ResultDialog.showDialog(this, lycee.getName(),"Voici les règles du jeu dans une Alertdialog personnalisée");
    }*/

    public void displayLycee(Activity activity, Lycee lycee) {
        Dialog dialog = new Dialog(activity, R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.result_dialog);
        Window window = dialog.getWindow();
        window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);

        dialogTextTitle = dialog.findViewById(R.id.result_dialog_title);
        dialogTextTitle.setText(lycee.getName());
        dialogText1 = dialog.findViewById(R.id.result_dialog_txt1);

        // Get the languages;
        String langues = "";
        int lvSize = lycee.getLangues().size();

        for (int i = 0; i < lvSize; i++) {
            if (i != lvSize - 1) {
                langues += lycee.getLangues().get(i).toString() + " | ";
            } else {
                langues += lycee.getLangues().get(i).toString() + "\n";
            }
        }

        //Get the specialities
        String specialities = "";
            int spSize = lycee.getSpecialities().size();

            for (int i = 0; i < spSize; i++) {
                if (i != lvSize - 1) {
                    specialities += lycee.getSpecialities().get(i).toString() + "\n";
                }
            }

        //Get the techno
        String techno = "";
        int tcSize = lycee.getTechno().size();

        if(tcSize != 0){
                for (int i = 0; i < tcSize; i++) {
                    if (i != lvSize - 1) {
                    techno += lycee.getTechno().get(i).toString() + "\n";
                    }
                 }
            }
        else{ techno = "aucun";}

        dialogText1.setText(String.format(LYCEE_LABEL, lycee.getRank(), lycee.getPopulation(), lycee.getDistance(),
                    langues, specialities, techno));
            //dialogText1.setText(lycee.getPopulation() + " élèves" + "\n" + "Rang : " + lycee.getRank());
            dialog.show();

            Button dialogButton = findViewById(R.id.result_button);

        }
    }




