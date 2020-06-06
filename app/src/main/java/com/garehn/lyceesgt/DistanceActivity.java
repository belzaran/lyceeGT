package com.garehn.lyceesgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.garehn.lyceesgt.lycees.DoubleCursus;

import com.garehn.lyceesgt.lycees.Langues;
import com.garehn.lyceesgt.lycees.Lycee;
import com.garehn.lyceesgt.lycees.Specialities;
import com.garehn.lyceesgt.lycees.Techno;

public class DistanceActivity extends AppCompatActivity implements View.OnClickListener {

    static public int maxLycees = 6;
    public Lycee[] lycees = new Lycee[maxLycees];
    private static final int GAME_ACTIVITY_REQUEST_CODE = 1;
    public static final String[] SCORE = new String[maxLycees];

    private SeekBar distanceBar1;
    private SeekBar distanceBar2;
    private Button buttonValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);
        createAssets();
        createLycee();
    }

    public void createAssets(){
        distanceBar1 = this.findViewById(R.id.distance_seekBar_q1);
        distanceBar2 = this.findViewById(R.id.distance_seekBar_q2);
        buttonValidate = this.findViewById(R.id.distance_button_start);
        buttonValidate.setOnClickListener(this);

        SCORE[0]="HUGO";
        SCORE[1]="CHARLEMAGNE";
        SCORE[2]="GERMAIN";
        SCORE[3]="ARAGO";
        SCORE[4]="BOUCHER";
        SCORE[5]="RAVEL";
    }

    public void createLycee(){
        //References for GPS coordinates : www.coordonnees-gps.fr

        // hugo
        Lycee hugo = new Lycee("Victor Hugo",48.85752487182617,2.3631656169891357);
        lycees[0] = hugo;
        hugo.setPopulation(491);
        hugo.setRanking(168);
        hugo.addLangue(Langues.ALL);
        hugo.addLangue(Langues.ESP);
        hugo.addLangue(Langues.ITA);
        hugo.addSpecialities(Specialities.THE);
        hugo.addSpecialities(Specialities.HIS);
        hugo.addSpecialities(Specialities.HUM);
        hugo.addSpecialities(Specialities.LAN);
        hugo.addSpecialities(Specialities.MAT);
        hugo.addSpecialities(Specialities.NUM);
        hugo.addSpecialities(Specialities.SVT);
        hugo.addSpecialities(Specialities.PHY);
        hugo.addSpecialities(Specialities.SES);
        hugo.addDoubleCursus(DoubleCursus.ESABAC);
        hugo.showInformation();

        // charlemagne
        Lycee charlemagne = new Lycee("Charlemagne", 48.85447692871094, 2.3606178760528564);
        lycees[1] = charlemagne;

        charlemagne.addLangue(Langues.ALL);
        charlemagne.addLangue(Langues.ESP);
        charlemagne.setPopulation(1014);
        charlemagne.setRanking(56);
        charlemagne.addSpecialities(Specialities.HIS);
        charlemagne.addSpecialities(Specialities.HUM);
        charlemagne.addSpecialities(Specialities.LAN);
        charlemagne.addSpecialities(Specialities.MAT);
        charlemagne.addSpecialities(Specialities.NUM);
        charlemagne.addSpecialities(Specialities.PHY);
        charlemagne.addSpecialities(Specialities.SVT);
        charlemagne.addSpecialities(Specialities.SES);
        charlemagne.showInformation();

        // SOPHIE germain
        Lycee germain = new Lycee("Sophie Germain", 48.8547103,2.3576802);
        lycees[2] = germain;
        germain.addLangue(Langues.ALL);
        germain.addLangue(Langues.POR);
        germain.addLangue(Langues.ESP);
        germain.addLangue(Langues.ITA);
        germain.setPopulation(861);
        germain.setRanking(78);
        germain.addSpecialities(Specialities.HIS);
        germain.addSpecialities(Specialities.HUM);
        germain.addSpecialities(Specialities.LAN);
        germain.addSpecialities(Specialities.MAT);
        germain.addSpecialities(Specialities.PHY);
        germain.addSpecialities(Specialities.SVT);
        germain.addSpecialities(Specialities.SES);
        germain.addSpecialities(Specialities.NUM);
        germain.addTechno(Techno.STMG);
        germain.showInformation();

        // arago
        Lycee arago = new Lycee("Arago", 48.8476161,2.393716 );
        lycees[3] = arago;
        arago.addLangue(Langues.ALL);
        arago.addLangue(Langues.ESP);
        arago.setPopulation(628);
        arago.setRanking(628);
        arago.addSpecialities(Specialities.HIS);
        arago.addSpecialities(Specialities.HUM);
        arago.addSpecialities(Specialities.MAT);
        arago.addSpecialities(Specialities.PHY);
        arago.addSpecialities(Specialities.SVT);
        arago.addSpecialities(Specialities.NUM);
        arago.addSpecialities(Specialities.SES);
        arago.addSpecialities(Specialities.SI);
        arago.addTechno(Techno.STMG);
        arago.showInformation();

        // boucher
        Lycee boucher = new Lycee("Hélène Boucher", 48.84785461425781, 2.407208204269409);
        lycees[4] = boucher;
        boucher.addLangue(Langues.ALL);
        boucher.addLangue(Langues.ESP);
        boucher.addLangue(Langues.CHI);
        boucher.setPopulation(1372);
        boucher.setRanking(369);
        boucher.addSpecialities(Specialities.HDA);
        boucher.addSpecialities(Specialities.HIS);
        boucher.addSpecialities(Specialities.HUM);
        boucher.addSpecialities(Specialities.LAN);
        boucher.addSpecialities(Specialities.LIT);
        boucher.addSpecialities(Specialities.MAT);
        boucher.addSpecialities(Specialities.NUM);
        boucher.addSpecialities(Specialities.PHY);
        boucher.addSpecialities(Specialities.SVT);
        boucher.addSpecialities(Specialities.SI);
        boucher.addSpecialities(Specialities.SES);

        boucher.showInformation();

        // ravel
        Lycee ravel = new Lycee("Maurice Ravel", 48.8479317, 2.4084678);
        lycees[5] = ravel;
        ravel.addLangue(Langues.ALL);
        ravel.addLangue(Langues.ESP);
        ravel.setPopulation(1423);
        ravel.setRanking(606);
        ravel.addSpecialities(Specialities.HIS);
        ravel.addSpecialities(Specialities.HUM);
        ravel.addSpecialities(Specialities.LAN);
        ravel.addSpecialities(Specialities.LIT);
        ravel.addSpecialities(Specialities.MAT);
        ravel.addSpecialities(Specialities.NUM);
        ravel.addSpecialities(Specialities.PHY);
        ravel.addSpecialities(Specialities.SVT);
        ravel.addSpecialities(Specialities.SES);
        ravel.addDoubleCursus(DoubleCursus.ABIBAC);
        ravel.addDoubleCursus(DoubleCursus.BACHIBAC);
        ravel.addTechno(Techno.STMG);
        ravel.showInformation();


    }

    @Override
    public void onClick(View v) {
        Log.i("GAREHN_DISTANCE"," CLICK");
        calculateScores(distanceBar1.getProgress(), distanceBar2.getProgress());


        Intent activity = new Intent(DistanceActivity.this, SizeActivity.class);

            for(int i = 0; i < maxLycees; i++) {
                activity.putExtra(SCORE[i], lycees[i]);
            }

            activity.putExtra("max", maxLycees);

        setResult(RESULT_OK, activity);
        startActivityForResult(activity, GAME_ACTIVITY_REQUEST_CODE);
    }

    public void calculateScores(int a, int b){
        Log.i("GAREHN_DISTANCE"," CALCULATE");

        int bonus = a+b;

        for (int i = 0; i<maxLycees; i++){
            if (lycees[i].getDistance() < 1500){
                lycees[i].setPoints(lycees[i].getPoints() + bonus);
            }
            else{

            }
            Log.i("GAREHN_DISTANCE",lycees[i].getName() + " : " + lycees[i].getPoints());
        }
    }
}