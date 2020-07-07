package com.garehn.lyceesgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.garehn.lyceesgt.lycees.Lycee;
import com.garehn.lyceesgt.lycees.Priorities;

public class RankActivity extends AppCompatActivity implements View.OnClickListener {

    public int maxLycees;
    public Lycee[] lycees;
    private static final int GAME_ACTIVITY_REQUEST_CODE = 12;
    public static String[] SCORE;
    public String priority;
    private Button buttonValidate;
    private SeekBar rankBar1;
    private SeekBar rankBar2;
    private SeekBar rankBar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        Log.i("GAREHN_RANK","  Connecting to RankActivity");

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
        rankBar1 = this.findViewById(R.id.rank_seekBar_q1);
        rankBar2 = this.findViewById(R.id.rank_seekBar_q2);
        rankBar3 = this.findViewById(R.id.rank_seekBar_q3);
        buttonValidate = this.findViewById(R.id.rank_button_start);
        buttonValidate.setOnClickListener(this);
        buttonValidate = findViewById(R.id.rank_button_start);
        buttonValidate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.i("GAREHN_rank"," CLICK");
        calculateScores(rankBar1.getProgress(), rankBar2.getProgress(), rankBar3.getProgress());

        Intent activity = new Intent(RankActivity.this, LangueActivity.class);

        for(int i = 0; i < maxLycees; i++) {
            activity.putExtra(SCORE[i], lycees[i]);
        }

        activity.putExtra("max", maxLycees);
        activity.putExtra("priority", priority);

        setResult(RESULT_OK, activity);
        startActivityForResult(activity, GAME_ACTIVITY_REQUEST_CODE);
        
    }

    public void calculateScores(int a, int b, int c){
        Log.i("GAREHN_RANK"," CALCULATE");

        //a = importance
        //b = wanted rank
        int bonus = a;
        int bad = 1000;
        int good = 400;

        if(priority.intern()== Priorities.RAN.toString().intern()){
            bonus *= 2 ;
            Log.i("GAREHN_RANK","Priority : point bonus");
        }

        for (int i = 0; i<maxLycees; i++){
            if (lycees[i].getRank() < good){
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
            else if (lycees[i].getRank() > bad){
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
            switch(c){
                case 0:
                    if(lycees[i].getSuccess()>= 80){
                        lycees[i].addPoints(bonus);
                    }
                    break;
                case 1:
                    if(lycees[i].getSuccess()>= 85){
                        lycees[i].addPoints(bonus);
                    }
                    break;
                case 2:
                    if(lycees[i].getSuccess()>= 90){
                        lycees[i].addPoints(bonus);
                    }
                    break;
                case 3:
                    if(lycees[i].getSuccess()>= 95){
                        lycees[i].addPoints(bonus);
                    }
                    break;
            }
            Log.i("GAREHN_RANK",lycees[i].getName() + " : " + lycees[i].getPoints());
        }
    }
}