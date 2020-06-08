package com.garehn.lyceesgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.garehn.lyceesgt.lycees.Langues;
import com.garehn.lyceesgt.lycees.Lycee;
import com.garehn.lyceesgt.lycees.Specialities;

public class SpecialityActivity extends AppCompatActivity implements View.OnClickListener {

    static public int maxLycees;
    public Lycee[] lycees;
    private static final int GAME_ACTIVITY_REQUEST_CODE = 4;
    public static String[] SCORE;

    private Switch switchLIT;
    private Switch switchHIS;
    private Switch switchHUM;
    private Switch switchLAN;
    private Switch switchMAT;
    private Switch switchNUM;
    private Switch switchPHY;
    private Switch switchSVT;
    private Switch switchSI;
    private Switch switchSES;
    private Switch switchTHE;
    private Switch switchHDA;
    private Button buttonValidate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speciality);
        Log.i("GAREHN_SPECIALITY", "  Connecting to SpecialityActivity");

        createAssets();

        // TAKE THE RESULTS OF THE LEVEL ACTIVITY (FIRST LINE OF THE TABLE)
        Intent intent = getIntent();
        maxLycees = intent.getIntExtra("max", 0);
        lycees = new Lycee[maxLycees];
        SCORE = new String[maxLycees];
        SCORE[0] = "HUGO";
        SCORE[1] = "CHARLEMAGNE";
        SCORE[2] = "GERMAIN";
        SCORE[3] = "ARAGO";
        SCORE[4] = "BOUCHER";
        SCORE[5] = "RAVEL";

        if (intent != null) {
            for (int i = 0; i < maxLycees; i++) {
                lycees[i] = intent.getParcelableExtra(SCORE[i]);
            }
        }
    }

    public void createAssets() {

        switchLIT = findViewById(R.id.speciality_switch_LIT);
        switchHIS = findViewById(R.id.speciality_switch_HIS);
        switchHUM = findViewById(R.id.speciality_switch_HUM);
        switchLAN = findViewById(R.id.speciality_switch_LAN);
        switchMAT = findViewById(R.id.speciality_switch_MAT);
        switchNUM = findViewById(R.id.speciality_switch_NUM);
        switchPHY = findViewById(R.id.speciality_switch_PHY);
        switchSVT = findViewById(R.id.speciality_switch_SVT);
        switchSI = findViewById(R.id.speciality_switch_SI);
        switchSES = findViewById(R.id.speciality_switch_SES);
        switchTHE = findViewById(R.id.speciality_switch_THE);
        switchHDA = findViewById(R.id.speciality_switch_HDA);

        buttonValidate = findViewById(R.id.speciality_button_start);
        buttonValidate.setOnClickListener(this);

    }

        @Override
        public void onClick (View v){
            Log.i("GAREHN_TECHNO", " CLICK");
            calculateScores(switchLIT.isChecked(), switchHIS.isChecked(), switchHUM.isChecked(), switchLAN.isChecked(), switchMAT.isChecked(),switchNUM.isChecked(),switchPHY.isChecked(),switchSVT.isChecked(),switchSI.isChecked(),switchSES.isChecked(),switchTHE.isChecked(),switchHDA.isChecked());


            Intent activity = new Intent(SpecialityActivity.this, TechnoActivity.class);

            for (int i = 0; i < maxLycees; i++) {
                activity.putExtra(SCORE[i], lycees[i]);
            }

            activity.putExtra("max", maxLycees);

            setResult(RESULT_OK, activity);
            startActivityForResult(activity, GAME_ACTIVITY_REQUEST_CODE);
        }

        public void calculateScores (boolean lit, boolean his, boolean hum, boolean lan, boolean mat, boolean num, boolean phy,boolean svt, boolean si, boolean ses, boolean the, boolean hda)
        {
            Log.i("GAREHN_SPECIALITY", " CALCULATE");

            //Calculate bonus
            int bonus = 2;

            for (int i = 0; i < maxLycees; i++) {

                if (lit) {
                    if (lycees[i].getSpecialities().contains(Specialities.LIT)) {
                        lycees[i].addPoints(bonus);
                    }
                }

                if (his) {
                    if (lycees[i].getSpecialities().contains(Specialities.HIS)) {
                        lycees[i].addPoints(bonus);
                    }
                }

                if (hum) {
                    if (lycees[i].getSpecialities().contains(Specialities.HUM)) {
                        lycees[i].addPoints(bonus);
                    }
                }

                if (lan) {
                    if (lycees[i].getSpecialities().contains(Specialities.LAN)) {
                        lycees[i].addPoints(bonus);
                    }
                }

                if (mat) {
                    if (lycees[i].getSpecialities().contains(Specialities.MAT)) {
                        lycees[i].addPoints(bonus);
                    }
                }

                if (num) {
                    if (lycees[i].getSpecialities().contains(Specialities.NUM)) {
                        lycees[i].addPoints(bonus);
                    }
                }

                if (phy) {
                    if (lycees[i].getSpecialities().contains(Specialities.PHY)) {
                        lycees[i].addPoints(bonus);
                    }
                }

                if (svt) {
                    if (lycees[i].getSpecialities().contains(Specialities.SVT)) {
                        lycees[i].addPoints(bonus);
                    }
                }

                if (si) {
                    if (lycees[i].getSpecialities().contains(Specialities.SI)) {
                        lycees[i].addPoints(bonus);
                    }
                }

                if (ses) {
                    if (lycees[i].getSpecialities().contains(Specialities.SES)) {
                        lycees[i].addPoints(bonus);
                    }
                }

                if (the) {
                    if (lycees[i].getSpecialities().contains(Specialities.THE)) {
                        lycees[i].addPoints(bonus);
                    }
                }

                if (hda) {
                    if (lycees[i].getSpecialities().contains(Specialities.HDA)) {
                        lycees[i].addPoints(bonus);
                    }
                }

                Log.i("GAREHN_SPECIALITY", lycees[i].getName() + " : " + lycees[i].getPoints());
            }
        }
    }


