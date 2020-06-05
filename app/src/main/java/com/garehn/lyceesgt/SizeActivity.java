package com.garehn.lyceesgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.garehn.lyceesgt.lycees.Lycee;

public class SizeActivity extends AppCompatActivity implements View.OnClickListener {

    static public int lyceesNumber = 6;
    public Lycee[] lycees = new Lycee[lyceesNumber];
    private static final int GAME_ACTIVITY_REQUEST_CODE = 4;
    public static final String[] SCORE = new String[lyceesNumber];
    
    private Button buttonValidate;
    private SeekBar sizeBar1;
    private SeekBar sizeBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size);

        Log.i("GAREHN_SIZE","  Connecting to SizeActivity");

        createAssets();

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

    public void createAssets(){

        sizeBar1 = this.findViewById(R.id.size_seekBar_q1);
        sizeBar2 = this.findViewById(R.id.size_seekBar_q2);
        buttonValidate = this.findViewById(R.id.size_button_start);
        buttonValidate.setOnClickListener(this);
        buttonValidate = findViewById(R.id.size_button_start);
        buttonValidate.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
  Log.i("GAREHN_SIZE"," CLICK");
    calculateScores(sizeBar1.getProgress(), sizeBar2.getProgress());


    Intent sizeActivity = new Intent(SizeActivity.this, LangueActivity.class);

            for(int i = 0; i < lyceesNumber; i++) {
        sizeActivity.putExtra(SCORE[i], lycees[i]);
    }

    setResult(RESULT_OK, sizeActivity);
    startActivityForResult(sizeActivity, GAME_ACTIVITY_REQUEST_CODE);
}

    public void calculateScores(int a, int b){
        Log.i("GAREHN_SIZE"," CALCULATE");

        int bonus = a;
        int small = 800;
        int big = 1000;

        for (int i = 0; i<lyceesNumber; i++){
            if (lycees[i].getPopulation() < 800){
                switch(b){
                    case 0:
                        lycees[i].addPoints(bonus * 2);
                        break;
                    case 1:
                        lycees[i].addPoints(bonus);
                        break;
                    case 2:
                        break;
                }
            }
            else if (lycees[i].getPopulation() > 1000){
                switch(b){
                    case 2:
                        lycees[i].addPoints(bonus * 2);
                        break;
                    case 1:
                        lycees[i].addPoints(bonus);
                        break;
                    case 0:
                        break;
                }
            }
            else {
                switch(b){
                    case 0:
                    case 2:
                        lycees[i].addPoints(bonus);
                        break;
                    case 1:
                        lycees[i].addPoints(bonus * 2);
                        break;
                }
            }
            Log.i("GAREHN_SIZE",lycees[i].getName() + " : " + lycees[i].getPoints());
        }
    }
}