package com.garehn.lyceesgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.garehn.lyceesgt.lycees.Lycee;

public class ResultActivity extends AppCompatActivity {

    static public int lyceesNumber = 6;
    public Lycee[] lycees = new Lycee[lyceesNumber];
    private static final int GAME_ACTIVITY_REQUEST_CODE = 69;
    public static final String[] SCORE = new String[lyceesNumber];

    private ProgressBar[] resultBar = new ProgressBar[lyceesNumber];
    private TextView[] resultText = new TextView[lyceesNumber];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
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

        showScores();

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
    }

    public void showScores(){

        //find the maximum of points
        int max = 0;

        for(int i = 0;i<lyceesNumber;i++) {
            if (lycees[i].getPoints() > max) {
                max = lycees[i].getPoints();
            }
        }

        //set the progressBars to the max points
        for(int i = 0;i<lyceesNumber;i++){
            resultBar[i].setMax(max);
        }


        for(int i = 0;i<lyceesNumber;i++){
            resultText[i].setText(lycees[i].getName());
            resultBar[i].setProgress(lycees[i].getPoints());
            //resultBar[i].setProgressTintList(ColorStateList.valueOf(Color.RED));
        }

    }
}