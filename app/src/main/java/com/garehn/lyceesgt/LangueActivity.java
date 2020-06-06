package com.garehn.lyceesgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

import com.garehn.lyceesgt.assets.CustomSwitch;
import com.garehn.lyceesgt.lycees.Langues;
import com.garehn.lyceesgt.lycees.Lycee;

public class LangueActivity extends AppCompatActivity implements View.OnClickListener {

    public int maxLycees;
    public Lycee[] lycees;
    private static final int GAME_ACTIVITY_REQUEST_CODE = 3;
    public static String[] SCORE;

    private SeekBar langueBar;
    private Switch switchEsp;
    private Switch switchAll;
    private Switch switchIta;
    private Switch switchPor;
    private Switch switchChi;
    private Button buttonValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_langue);

        Log.i("GAREHN_LANGUE","  Connecting to LangueActivity");

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

        langueBar = findViewById(R.id.langue_seekBar_q1);
        switchEsp = findViewById(R.id.langue_switch_ESP);
        switchAll = findViewById(R.id.langue_switch_ALL);
        switchIta = findViewById(R.id.langue_switch_ITA);
        switchPor = findViewById(R.id.langue_switch_POR);
        switchChi = findViewById(R.id.langue_switch_CHI);

        buttonValidate = findViewById(R.id.langue_button_start);
        buttonValidate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.i("GAREHN_DISTANCE"," CLICK");
        calculateScores(langueBar.getProgress(), switchEsp.isChecked(),switchAll.isChecked(), switchPor.isChecked(), switchIta.isChecked(), switchChi.isChecked());


        Intent activity = new Intent(LangueActivity.this, SpecialityActivity.class);

        for(int i = 0; i < maxLycees; i++) {
            activity.putExtra(SCORE[i], lycees[i]);
        }

        activity.putExtra("max", maxLycees);

        setResult(RESULT_OK, activity);
        startActivityForResult(activity, GAME_ACTIVITY_REQUEST_CODE);
    }

    public void calculateScores(int a, boolean esp, boolean all, boolean por, boolean ita, boolean chi){
        Log.i("GAREHN_LANGUE"," CALCULATE");

        //Calculate bonus
        int bonus = a*2;
        if (bonus == 0){
            bonus = 1;
        }

        for(int i = 0; i<maxLycees; i++){

            if(esp) {
                if (lycees[i].getLangues().contains(Langues.ESP)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if(all) {
                if (lycees[i].getLangues().contains(Langues.ALL)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if(por) {
                if (lycees[i].getLangues().contains(Langues.POR)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if(ita) {
                if (lycees[i].getLangues().contains(Langues.ITA)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if(chi) {
                if (lycees[i].getLangues().contains(Langues.CHI)) {
                    lycees[i].addPoints(bonus);
                }
            }

            Log.i("GAREHN_LANGUE",lycees[i].getName() + " : " + lycees[i].getPoints());

        }

        }

        /*public int booleanToInt(boolean b){
        int result = 0;
        if (b){
            result = 1;
            }
        else{
            result =0;
            }
        return result;

        }*/
    }


