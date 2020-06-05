package com.garehn.lyceesgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.garehn.lyceesgt.lycees.Lycee;

public class SpecialityActivity extends AppCompatActivity {

    static public int lyceesNumber = 6;
    public Lycee[] lycees = new Lycee[lyceesNumber];
    private static final int GAME_ACTIVITY_REQUEST_CODE = 3;
    public static final String[] SCORE = new String[lyceesNumber];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speciality);
        Log.i("GAREHN_SPECIALITY","  Connecting to SpecialityActivity");

        //createAssets();

        // TAKE THE RESULTS OF THE LEVEL ACTIVITY (FIRST LINE OF THE TABLE)
        SCORE[0]="HUGO";
        SCORE[1]="CHARLEMAGNE";
        SCORE[2]="GERMAIN";
        SCORE[3]="ARAGO";
        SCORE[4]="BOUCHER";
        SCORE[5]="RAVEL";
        Intent intent = getIntent();
        if (intent != null) {
            for (int i = 0; i < lyceesNumber; i++) {
                lycees[i] = intent.getParcelableExtra(SCORE[i]);
            }
        }

        lycees[2].showInformation();
    }
}