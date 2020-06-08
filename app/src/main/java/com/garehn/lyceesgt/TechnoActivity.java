package com.garehn.lyceesgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.garehn.lyceesgt.lycees.Lycee;
import com.garehn.lyceesgt.lycees.Techno;
import com.garehn.lyceesgt.lycees.Techno;

public class TechnoActivity extends AppCompatActivity implements View.OnClickListener{

    public int maxLycees;
    public Lycee[] lycees;
    private static final int GAME_ACTIVITY_REQUEST_CODE = 5;
    public static String[] SCORE;

    private Switch switchSTMG;
    private Switch switchSTL;
    private Switch switchSTD2A;
    private Switch switchSTI2D;
    private Switch switchSTHR;
    private Switch switchST2S;
    private Button buttonValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techno);

        Log.i("GAREHN_TECHNO","  Connecting to TechnoActivity");

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
    }

    public void createAssets(){

        switchSTMG = findViewById(R.id.techno_switch_STMG);
        switchSTL = findViewById(R.id.techno_switch_STL);
        switchSTHR = findViewById(R.id.techno_switch_STHR);
        switchSTD2A = findViewById(R.id.techno_switch_STD2A);
        switchSTI2D = findViewById(R.id.techno_switch_STI2D);
        switchST2S = findViewById(R.id.techno_switch_ST2S);

        buttonValidate = findViewById(R.id.techno_button_start);
        buttonValidate.setOnClickListener(this);

    }

    @Override
    public void onClick (View v){
        Log.i("GAREHN_TECHNO", " CLICK");
        calculateScores(switchSTMG.isChecked(), switchSTL.isChecked(), switchSTHR.isChecked(), switchSTD2A.isChecked(), switchSTI2D.isChecked(),switchST2S.isChecked());

        Intent activity = new Intent(TechnoActivity.this, ResultActivity.class);

        for (int i = 0; i < maxLycees; i++) {
            activity.putExtra(SCORE[i], lycees[i]);
        }

        activity.putExtra("max", maxLycees);

        setResult(RESULT_OK, activity);
        startActivityForResult(activity, GAME_ACTIVITY_REQUEST_CODE);
    }

    public void calculateScores (boolean stmg, boolean stl, boolean sthr, boolean std2a, boolean sti2d, boolean st2s)
    {
        Log.i("GAREHN_TECHNO", " CALCULATE");

        //Calculate bonus
        int bonus = 4;

        for (int i = 0; i < maxLycees; i++) {

            if (lycees[i] != null){

            if (stmg) {

                  if(lycees[i].getTechno().contains(Techno.STMG)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if (stl) {
                if (lycees[i].getTechno().contains(Techno.STL)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if (sthr) {
                if (lycees[i].getTechno().contains(Techno.STHR)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if (sti2d) {
                if (lycees[i].getTechno().contains(Techno.STI2D)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if (st2s) {
                if (lycees[i].getTechno().contains(Techno.ST2S)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if (std2a) {
                if (lycees[i].getTechno().contains(Techno.STD2A)) {
                    lycees[i].addPoints(bonus);
                }
            }
                Log.i("GAREHN_TECHNO", lycees[i].getName() + " : " + lycees[i].getPoints());
            }


        }
    }
}
