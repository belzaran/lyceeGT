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

    static public int lyceesNumber = 6;
    public Lycee[] lycees = new Lycee[lyceesNumber];
    private static final int GAME_ACTIVITY_REQUEST_CODE = 1;
    public static final String[] SCORE = new String[lyceesNumber];

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
        hugo.addSpecialities(Specialities.THEATRE);
        hugo.addSpecialities(Specialities.HISTOIRE);
        hugo.addSpecialities(Specialities.HUMANITES);
        hugo.addSpecialities(Specialities.LANGUES);
        hugo.addSpecialities(Specialities.MATHS);
        hugo.addSpecialities(Specialities.NUMERIQUE);
        hugo.addSpecialities(Specialities.SVT);
        hugo.addSpecialities(Specialities.PHYSIQUE);
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
        charlemagne.addSpecialities(Specialities.HISTOIRE);
        charlemagne.addSpecialities(Specialities.HUMANITES);
        charlemagne.addSpecialities(Specialities.LANGUES);
        charlemagne.addSpecialities(Specialities.MATHS);
        charlemagne.addSpecialities(Specialities.NUMERIQUE);
        charlemagne.addSpecialities(Specialities.PHYSIQUE);
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
        germain.addSpecialities(Specialities.HISTOIRE);
        germain.addSpecialities(Specialities.HUMANITES);
        germain.addSpecialities(Specialities.LANGUES);
        germain.addSpecialities(Specialities.MATHS);
        germain.addSpecialities(Specialities.PHYSIQUE);
        germain.addSpecialities(Specialities.SVT);
        germain.addSpecialities(Specialities.SES);
        germain.addSpecialities(Specialities.NUMERIQUE);
        germain.addTechno(Techno.STMG);
        germain.showInformation();

        // arago
        Lycee arago = new Lycee("Arago", 48.8476161,2.393716 );
        lycees[3] = arago;
        arago.addLangue(Langues.ALL);
        arago.addLangue(Langues.ESP);
        arago.setPopulation(628);
        arago.setRanking(628);
        arago.addSpecialities(Specialities.HISTOIRE);
        arago.addSpecialities(Specialities.HUMANITES);
        arago.addSpecialities(Specialities.MATHS);
        arago.addSpecialities(Specialities.PHYSIQUE);
        arago.addSpecialities(Specialities.SVT);
        arago.addSpecialities(Specialities.NUMERIQUE);
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
        boucher.addSpecialities(Specialities.HISTOIRE);
        boucher.addSpecialities(Specialities.HUMANITES);
        boucher.addSpecialities(Specialities.LANGUES);
        boucher.addSpecialities(Specialities.LITTERATURE);
        boucher.addSpecialities(Specialities.MATHS);
        boucher.addSpecialities(Specialities.NUMERIQUE);
        boucher.addSpecialities(Specialities.PHYSIQUE);
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
        ravel.addSpecialities(Specialities.HISTOIRE);
        ravel.addSpecialities(Specialities.HUMANITES);
        ravel.addSpecialities(Specialities.LANGUES);
        ravel.addSpecialities(Specialities.LITTERATURE);
        ravel.addSpecialities(Specialities.MATHS);
        ravel.addSpecialities(Specialities.NUMERIQUE);
        ravel.addSpecialities(Specialities.PHYSIQUE);
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


        Intent distanceActivity = new Intent(DistanceActivity.this, SizeActivity.class);

            for(int i = 0; i < lyceesNumber; i++) {
                distanceActivity.putExtra(SCORE[i], lycees[i]);
            }

        setResult(RESULT_OK, distanceActivity);
        startActivityForResult(distanceActivity, GAME_ACTIVITY_REQUEST_CODE);
    }

    public void calculateScores(int a, int b){
        Log.i("GAREHN_DISTANCE"," CALCULATE");

        int bonus = a+b;

        for (int i = 0; i<lyceesNumber; i++){
            if (lycees[i].getDistance() < 1500){
                lycees[i].setPoints(lycees[i].getPoints() + bonus);
            }
            else{

            }
            Log.i("GAREHN_DISTANCE",lycees[i].getName() + " : " + lycees[i].getPoints());
        }
    }
}