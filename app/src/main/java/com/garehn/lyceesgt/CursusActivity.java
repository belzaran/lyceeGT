package com.garehn.lyceesgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

import com.garehn.lyceesgt.lycees.DoubleCursus;
import com.garehn.lyceesgt.lycees.Lycee;
import com.garehn.lyceesgt.lycees.Priorities;

public class CursusActivity extends AppCompatActivity implements View.OnClickListener {

    public int maxLycees;
    public Lycee[] lycees;
    private static final int GAME_ACTIVITY_REQUEST_CODE = 21;
    public static String[] SCORE;
    public String priority;

    private Switch switchBiEsp;
    private Switch switchBiAll;
    private Switch switchBiIta;
    private Switch switchEuroPor;
    private Switch switchEuroAll;
    private Switch switchEuroEsp;
    private Switch switchEuroAng;
    private Switch switchIntAng;
    private Switch switchBACHIBAC;
    private Switch switchABIBAC;
    private Switch switchESABAC;
    private Button buttonValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursus);

        Log.i("GAREHN_CURSUS","  Connecting to CursusActivity");

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


        switchBiEsp = findViewById(R.id.cursus_switch_BIESP);
        switchBiAll = findViewById(R.id.cursus_switch_BIALL);
        switchBiIta = findViewById(R.id.cursus_switch_BIITA);
        switchEuroEsp = findViewById(R.id.cursus_switch_EUROESP);
        switchEuroAll = findViewById(R.id.cursus_switch_EUROALL);
        switchEuroAng = findViewById(R.id.cursus_switch_EUROANG);
        switchEuroPor = findViewById(R.id.cursus_switch_EUROPOR);
        switchIntAng = findViewById(R.id.cursus_switch_INTANG);
        switchBACHIBAC = findViewById(R.id.cursus_switch_BACHIBAC);
        switchABIBAC = findViewById(R.id.cursus_switch_ABIBAC);
        switchESABAC = findViewById(R.id.cursus_switch_ESABAC);
        buttonValidate = findViewById(R.id.cursus_button_start);
        buttonValidate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.i("GAREHN_Cursus"," CLICK");
        calculateScores(switchABIBAC.isChecked(),switchESABAC.isChecked(),
                switchBACHIBAC.isChecked(), switchBiEsp.isChecked(),switchBiAll.isChecked(),
                switchBiIta.isChecked(), switchEuroAll.isChecked(),
                switchEuroAng.isChecked(),switchEuroEsp.isChecked(), switchEuroPor.isChecked(), switchIntAng.isChecked());

        Intent activity = new Intent(CursusActivity.this, SpecialityActivity.class);

        for(int i = 0; i < maxLycees; i++) {
            activity.putExtra(SCORE[i], lycees[i]);
        }

        activity.putExtra("max", maxLycees);
        activity.putExtra("priority", priority);

        setResult(RESULT_OK, activity);
        startActivityForResult(activity, GAME_ACTIVITY_REQUEST_CODE);
    }

    public void calculateScores(boolean abibac, boolean esabac, boolean bachibac, boolean biesp, boolean biall, boolean biita, boolean euroall, boolean euroang, boolean euroesp, boolean europor, boolean intang){
        Log.i("GAREHN_CURSUS"," CALCULATE");

        //Calculate bonus
        int bonus = 1;

        if(priority.intern()== Priorities.LAN.toString().intern()){
            bonus *= 2 ;
            Log.i("GAREHN_CURSUS","Priority : point bonus");
        }

        for(int i = 0; i<maxLycees; i++){

            if(abibac) {
                if (lycees[i].getDoubleCursus().contains(DoubleCursus.ABIBAC)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if(bachibac) {
                if (lycees[i].getDoubleCursus().contains(DoubleCursus.BACHIBAC)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if(esabac) {
                if (lycees[i].getDoubleCursus().contains(DoubleCursus.ESABAC)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if(biall) {
                if (lycees[i].getDoubleCursus().contains(DoubleCursus.BIALL)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if(biesp) {
                if (lycees[i].getDoubleCursus().contains(DoubleCursus.BIESP)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if(biita) {
                if (lycees[i].getDoubleCursus().contains(DoubleCursus.BIITA)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if(euroall) {
                if (lycees[i].getDoubleCursus().contains(DoubleCursus.EUROALL)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if(euroang) {
                if (lycees[i].getDoubleCursus().contains(DoubleCursus.EUROANG)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if(euroesp) {
                if (lycees[i].getDoubleCursus().contains(DoubleCursus.EUROESP)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if(europor) {
                if (lycees[i].getDoubleCursus().contains(DoubleCursus.EUROPOR)) {
                    lycees[i].addPoints(bonus);
                }
            }

            if(intang) {
                if (lycees[i].getDoubleCursus().contains(DoubleCursus.INTANG)) {
                    lycees[i].addPoints(bonus);
                }
            }

            Log.i("GAREHN_CURSUS",lycees[i].getName() + " : " + lycees[i].getPoints());

        }

    }

}


