package com.garehn.lyceesgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import com.garehn.lyceesgt.lycees.Langues;
import com.garehn.lyceesgt.lycees.Lycee;
import com.garehn.lyceesgt.lycees.Priorities;

public class LangueActivity extends AppCompatActivity implements View.OnClickListener {

    public int maxLycees;
    public Lycee[] lycees;
    private static final int GAME_ACTIVITY_REQUEST_CODE = 20;
    public static String[] SCORE;
    public String priority;

    private SeekBar langueBar;
    private Switch switchEsp;
    private Switch switchAll;
    private Switch switchIta;
    private Switch switchPor;
    private Switch switchChi;
    private Switch switchSud;
    private Switch switchRus;
    private Switch switchAra;
    private Switch switchJap;
    private Button buttonValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_langue);

        Log.i("GAREHN_LANGUE","  Connecting to LangueActivity");

        createAssets();

        Intent intent = getIntent();
        if (intent != null) {
            priority = intent.getStringExtra("priority");
            maxLycees = intent.getIntExtra("max", 0);

            lycees = new Lycee[maxLycees];
            SCORE = new String[maxLycees];
            SCORE[0]="HUGO";
            SCORE[1]="CHARLEMAGNE";
            SCORE[2]="GERMAIN";
            SCORE[3]="ARAGO";
            SCORE[4]="BOUCHER";
            SCORE[5]="RAVEL";
            SCORE[6]="WEIL";
            SCORE[7]="TURGOT";
            SCORE[8]="COLBERT";
            SCORE[9]="DORIAN";
            SCORE[10]="VOLTAIRE";
            SCORE[11]="LEMONNIER";
            SCORE[12]="VALERY";
            SCORE[13]="BERGSON";
            SCORE[14]="DIDEROT";
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
        switchRus = findViewById(R.id.langue_switch_RUS);
        switchSud = findViewById(R.id.langue_switch_SUD);
        switchAra = findViewById(R.id.langue_switch_ARA);
        switchJap = findViewById(R.id.langue_switch_JAP);

        buttonValidate = findViewById(R.id.langue_button_start);
        buttonValidate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.i("GAREHN_DISTANCE"," CLICK");
        calculateScores(langueBar.getProgress(), switchEsp.isChecked(),switchAll.isChecked(),
                switchPor.isChecked(), switchIta.isChecked(), switchChi.isChecked(),
                switchRus.isChecked(),switchSud.isChecked(), switchAra.isChecked(), switchJap.isChecked());

        Intent activity = new Intent(LangueActivity.this, SpecialityActivity.class);

        for(int i = 0; i < maxLycees; i++) {
            activity.putExtra(SCORE[i], lycees[i]);
        }

        activity.putExtra("max", maxLycees);
        activity.putExtra("priority", priority);

        setResult(RESULT_OK, activity);
        startActivityForResult(activity, GAME_ACTIVITY_REQUEST_CODE);
    }

    public void calculateScores(int a, boolean esp, boolean all, boolean por, boolean ita, boolean chi, boolean rus, boolean sud, boolean ara, boolean jap){
        Log.i("GAREHN_LANGUE"," CALCULATE");

        //Calculate bonus
        int bonus = a*2;
        if (bonus == 0){
            bonus = 1;
        }

        if(priority.intern()== Priorities.LAN.toString().intern()){
            bonus *= 2 ;
            Log.i("GAREHN_LANGUE","Priority : point bonus");
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

            if(rus) {
                if (lycees[i].getLangues().contains(Langues.RUS)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if(sud) {
                if (lycees[i].getLangues().contains(Langues.SUD)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if(ara) {
                if (lycees[i].getLangues().contains(Langues.ARA)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if(jap) {
                if (lycees[i].getLangues().contains(Langues.JAP)) {
                    lycees[i].addPoints(bonus);
                }
            }

            Log.i("GAREHN_LANGUE",lycees[i].getName() + " : " + lycees[i].getPoints());

        }

        }

    }


