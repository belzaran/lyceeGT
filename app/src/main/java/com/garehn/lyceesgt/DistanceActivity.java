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
import com.garehn.lyceesgt.lycees.Priorities;
import com.garehn.lyceesgt.lycees.Specialities;
import com.garehn.lyceesgt.lycees.Techno;

public class DistanceActivity extends AppCompatActivity implements View.OnClickListener {

    static public int maxLycees = 15;
    public Lycee[] lycees = new Lycee[maxLycees];
    private static final int GAME_ACTIVITY_REQUEST_CODE = 10;
    public static final String[] SCORE = new String[maxLycees];
    public String priority;
    private SeekBar distanceBar1;
    private SeekBar distanceBar2;
    private Button buttonValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);
        createAssets();

        // TAKE THE RESULTS OF THE LEVEL ACTIVITY (FIRST LINE OF THE TABLE)
        Intent intent = getIntent();

        if (intent != null) {
            priority = intent.getStringExtra("priority");
        }

        Log.i("GAREHN_DISTANCE",priority);
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
        SCORE[6]="WEIL";
        SCORE[7]="TURGOT";
        SCORE[8]="COLBERT";
        SCORE[9]="DORIAN";
        SCORE[10]="VOLTAIRE";
        SCORE[11]="LEMONNIER";
        SCORE[12]="VALERY";
        SCORE[13]="BERGSON";
        SCORE[14]="DIDEROT";
    }

    public void createLycee(){
        //References for GPS coordinates : www.coordonnees-gps.fr
        //References for schools : https://ville-data.com

        // hugo
        Lycee hugo = new Lycee("Victor Hugo",48.85752487182617,2.3631656169891357);
        lycees[0] = hugo;
        hugo.setSuccess(96);
        hugo.setPopulation(491);
        hugo.setRank(168);
        hugo.setSecondPopulation(175);
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
        hugo.addDoubleCursus(DoubleCursus.BIITA);
        hugo.showInformation();

        // charlemagne
        Lycee charlemagne = new Lycee("Charlemagne", 48.85447692871094, 2.3606178760528564);
        lycees[1] = charlemagne;
        charlemagne.setPopulation(1014);
        charlemagne.setRank(56);
        charlemagne.setSuccess(98);
        charlemagne.setSecondPopulation(256);
        charlemagne.addLangue(Langues.ALL);
        charlemagne.addLangue(Langues.ESP);
        charlemagne.addSpecialities(Specialities.HIS);
        charlemagne.addSpecialities(Specialities.HUM);
        charlemagne.addSpecialities(Specialities.LAN);
        charlemagne.addSpecialities(Specialities.MAT);
        charlemagne.addSpecialities(Specialities.NUM);
        charlemagne.addSpecialities(Specialities.PHY);
        charlemagne.addSpecialities(Specialities.SVT);
        charlemagne.addSpecialities(Specialities.SES);
        charlemagne.showInformation();

        // sophie germain
        Lycee germain = new Lycee("Sophie Germain", 48.85492706298828,2.358180284500122);
        lycees[2] = germain;
        germain.setPopulation(861);
        germain.setRank(78);
        germain.setSuccess(99);
        germain.setSecondPopulation(282);
        germain.addLangue(Langues.ALL);
        germain.addLangue(Langues.POR);
        germain.addLangue(Langues.ESP);
        germain.addLangue(Langues.ITA);
        germain.addSpecialities(Specialities.HIS);
        germain.addSpecialities(Specialities.HUM);
        germain.addSpecialities(Specialities.LAN);
        germain.addSpecialities(Specialities.MAT);
        germain.addSpecialities(Specialities.PHY);
        germain.addSpecialities(Specialities.SVT);
        germain.addSpecialities(Specialities.SES);
        germain.addSpecialities(Specialities.NUM);
        germain.addDoubleCursus(DoubleCursus.EUROALL);
        germain.addDoubleCursus(DoubleCursus.EUROANG);
        germain.addDoubleCursus(DoubleCursus.EUROPOR);
        germain.addTechno(Techno.STMG);
        germain.showInformation();

        // arago
        Lycee arago = new Lycee("Arago", 48.84732437133789,2.3957626819610596);
        lycees[3] = arago;
        arago.addLangue(Langues.ALL);
        arago.addLangue(Langues.ESP);
        arago.setPopulation(751);
        arago.setRank(628);
        arago.setSuccess(97);
        arago.setSecondPopulation(244);
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
        boucher.setRank(369);
        boucher.setSuccess(95);
        boucher.setSecondPopulation(428);
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
        boucher.addDoubleCursus(DoubleCursus.EUROANG);
        boucher.addDoubleCursus(DoubleCursus.EUROESP);
        boucher.showInformation();

        // ravel
        Lycee ravel = new Lycee("Maurice Ravel", 48.847877502441406, 2.405076742172241);
        lycees[5] = ravel;
        ravel.addLangue(Langues.ALL);
        ravel.addLangue(Langues.ESP);
        ravel.setPopulation(1423);
        ravel.setRank(606);
        ravel.setSuccess(95);
        ravel.setSecondPopulation(458);
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
        ravel.addDoubleCursus(DoubleCursus.BIALL);
        ravel.addDoubleCursus(DoubleCursus.BIESP);
        ravel.addDoubleCursus(DoubleCursus.EUROALL);
        ravel.addDoubleCursus(DoubleCursus.EUROESP);
        ravel.addDoubleCursus(DoubleCursus.INTANG);
        ravel.addTechno(Techno.STMG);
        ravel.showInformation();

        // weil
        Lycee weil = new Lycee("Simone Weil", 48.861565, 2.287592);
        lycees[6] = weil;
        weil.setPopulation(387);
        weil.setRank(1879);
        weil.setSuccess(91);
        weil.setSecondPopulation(93);
        weil.addLangue(Langues.ALL);
        weil.addLangue(Langues.ESP);
        weil.addSpecialities(Specialities.HIS);
        weil.addSpecialities(Specialities.HUM);
        weil.addSpecialities(Specialities.LAN);
        weil.addSpecialities(Specialities.MAT);
        weil.addSpecialities(Specialities.NUM);
        weil.addSpecialities(Specialities.SES);
        weil.addTechno(Techno.STMG);

        // turgot
        Lycee turgot = new Lycee("Turgot",48.862725,2.287592);
        lycees[7] = turgot;
        turgot.setPopulation(1371);
        turgot.setRank(454);
        turgot.setSuccess(95);
        turgot.setSecondPopulation(234);
        turgot.addLangue(Langues.ALL);
        turgot.addLangue(Langues.CHI);
        turgot.addLangue(Langues.ESP);
        turgot.addSpecialities(Specialities.CIN);
        turgot.addSpecialities(Specialities.HIS);
        turgot.addSpecialities(Specialities.HUM);
        turgot.addSpecialities(Specialities.LAN);
        turgot.addSpecialities(Specialities.MAT);
        turgot.addSpecialities(Specialities.NUM);
        turgot.addSpecialities(Specialities.PHY);
        turgot.addSpecialities(Specialities.SVT);
        turgot.addSpecialities(Specialities.SES);
        turgot.addTechno(Techno.STMG);

        // colbert
        Lycee colbert = new Lycee("Colbert", 48.881961822509766, 2.363201379776001);
        lycees[8] = colbert;
        colbert.setPopulation(638);
        colbert.setRank(2222);
        colbert.setSuccess(87);
        colbert.setSecondPopulation(182);
        colbert.addLangue(Langues.ESP);
        colbert.addLangue(Langues.ALL);
        colbert.addLangue(Langues.RUS);
        colbert.addLangue(Langues.SUD);
        colbert.addSpecialities(Specialities.HIS);
        colbert.addSpecialities(Specialities.HUM);
        colbert.addSpecialities(Specialities.LAN);
        colbert.addSpecialities(Specialities.MAT);
        colbert.addSpecialities(Specialities.NUM);
        colbert.addSpecialities(Specialities.PHY);
        colbert.addSpecialities(Specialities.SVT);
        colbert.addSpecialities(Specialities.SES);
        colbert.addSpecialities(Specialities.ART);
        colbert.addDoubleCursus(DoubleCursus.EUROANG);

        // dorian
        Lycee dorian = new Lycee("Dorian",48.85615158081055, 2.3911025524139404);
        lycees[9] = dorian;
        dorian.setPopulation(969);
        dorian.setRank(1869);
        dorian.setSuccess(91);
        dorian.setSecondPopulation(154);
        dorian.addLangue(Langues.ALL);
        dorian.addLangue(Langues.ESP);
        dorian.addSpecialities(Specialities.HIS);
        dorian.addSpecialities(Specialities.MAT);
        dorian.addSpecialities(Specialities.NUM);
        dorian.addSpecialities(Specialities.PHY);
        dorian.addSpecialities(Specialities.SVT);
        dorian.addSpecialities(Specialities.SES);
        dorian.addSpecialities(Specialities.SI);
        dorian.addTechno(Techno.STI2D);

        // voltaire
        Lycee voltaire = new Lycee("Voltaire", 48.86386489868164,2.3819758892059326 );
        lycees[10] = voltaire;
        voltaire.setPopulation(1139);
        voltaire.setRank(2263);
        voltaire.setSuccess(84);
        voltaire.setSecondPopulation(419);
        voltaire.addLangue(Langues.ALL);
        voltaire.addLangue(Langues.ARA);
        voltaire.addLangue(Langues.CHI);
        voltaire.addLangue(Langues.ESP);
        voltaire.addLangue(Langues.JAP);
        voltaire.addLangue(Langues.ITA);
        voltaire.addSpecialities(Specialities.HIS);
        voltaire.addSpecialities(Specialities.ART);
        voltaire.addSpecialities(Specialities.HUM);
        voltaire.addSpecialities(Specialities.LAN);
        voltaire.addSpecialities(Specialities.MAT);
        voltaire.addSpecialities(Specialities.PHY);
        voltaire.addSpecialities(Specialities.SVT);
        voltaire.addSpecialities(Specialities.SI);
        voltaire.addSpecialities(Specialities.SES);
        voltaire.addDoubleCursus(DoubleCursus.EUROANG);

        // lemonnier
        Lycee lemonnier = new Lycee("Elisa Lemonnier", 48.8359260559082, 2.4088594913482666);
        lycees[11] = lemonnier;
        lemonnier.setPopulation(1256);
        lemonnier.setRank(1887);
        lemonnier.setSuccess(92);
        lemonnier.setSecondPopulation(134);
        lemonnier.addLangue(Langues.ALL);
        lemonnier.addLangue(Langues.ESP);
        lemonnier.addSpecialities(Specialities.HIS);
        lemonnier.addSpecialities(Specialities.HUM);
        lemonnier.addSpecialities(Specialities.LAN);
        lemonnier.addSpecialities(Specialities.MAT);
        lemonnier.addSpecialities(Specialities.NUM);
        lemonnier.addSpecialities(Specialities.PHY);
        lemonnier.addSpecialities(Specialities.SVT);
        lemonnier.addSpecialities(Specialities.SES);
        lemonnier.addTechno(Techno.STMG);

        //valery
        Lycee valery = new Lycee("Paul Valéry",48.84073257446289,2.4092459678649902);
        lycees[12] = valery;
        valery.setPopulation(975);
        valery.setRank(2277);
        valery.setSuccess(77);
        valery.setSecondPopulation(297);
        valery.addLangue(Langues.ALL);
        valery.addLangue(Langues.CHI);
        valery.addLangue(Langues.ESP);
        valery.addLangue(Langues.ITA);
        valery.addSpecialities(Specialities.HIS);
        valery.addSpecialities(Specialities.ART);
        valery.addSpecialities(Specialities.CIN);
        valery.addSpecialities(Specialities.HUM);
        valery.addSpecialities(Specialities.LAN);
        valery.addSpecialities(Specialities.MAT);
        valery.addSpecialities(Specialities.NUM);
        valery.addSpecialities(Specialities.PHY);
        valery.addSpecialities(Specialities.SVT);
        valery.addSpecialities(Specialities.SES);
        valery.addTechno(Techno.STI2D);
        valery.addDoubleCursus(DoubleCursus.EUROANG);
        valery.addDoubleCursus(DoubleCursus.EUROESP);

        //bergson
        Lycee bergson = new Lycee("Bergson-Jacquard", 48.880836486816406, 2.3774421215057373);
        lycees[13] = bergson;
        bergson.setPopulation(817);
        bergson.setRank(2234);
        bergson.setSuccess(79);
        bergson.setSecondPopulation(266);
        bergson.addLangue(Langues.ALL);
        bergson.addLangue(Langues.ESP);
        bergson.addLangue(Langues.ITA);
        bergson.addSpecialities(Specialities.HIS);
        bergson.addSpecialities(Specialities.HUM);
        bergson.addSpecialities(Specialities.LAN);
        bergson.addSpecialities(Specialities.MAT);
        bergson.addSpecialities(Specialities.NUM);
        bergson.addSpecialities(Specialities.PHY);
        bergson.addSpecialities(Specialities.SVT);
        bergson.addSpecialities(Specialities.SI);
        bergson.addSpecialities(Specialities.SES);
        bergson.addTechno(Techno.STI2D);
        bergson.addTechno(Techno.STMG);
        bergson.addDoubleCursus(DoubleCursus.EUROANG);

        //diderot
        Lycee diderot = new Lycee("Diderot",48.88219451904297, 2.3922524452209473);
        lycees[14] = diderot;
        diderot.setPopulation(1103);
        diderot.setRank(1182);
        diderot.setSuccess(96);
        diderot.setSecondPopulation(244);
        diderot.addLangue(Langues.ALL);
        diderot.addLangue(Langues.CHI);
        diderot.addLangue(Langues.ESP);
        diderot.addLangue(Langues.POR);
        diderot.addSpecialities(Specialities.LAN);
        diderot.addSpecialities(Specialities.HUM);
        diderot.addSpecialities(Specialities.MAT);
        diderot.addSpecialities(Specialities.NUM);
        diderot.addSpecialities(Specialities.PHY);
        diderot.addSpecialities(Specialities.SVT);
        diderot.addSpecialities(Specialities.SI);
        diderot.addSpecialities(Specialities.SES);
        diderot.addTechno(Techno.STI2D);

        for (int i = 0; i<maxLycees;i++){
            lycees[i].setId(i);
        }
    }

    @Override
    public void onClick(View v) {
        Log.i("GAREHN_DISTANCE"," Click");
        calculateScores(distanceBar1.getProgress(), distanceBar2.getProgress());

        Intent activity = new Intent(DistanceActivity.this, SizeActivity.class);
        for(int i = 0; i < maxLycees; i++) {
            activity.putExtra(SCORE[i], lycees[i]);
        }
        activity.putExtra("max", maxLycees);
        activity.putExtra("priority", priority);
        setResult(RESULT_OK, activity);
        startActivityForResult(activity, GAME_ACTIVITY_REQUEST_CODE);
    }

    public void calculateScores(int a, int b){
        Log.i("GAREHN_DISTANCE"," Calculate");

        int bonus = a+b;

        if(priority.intern()==Priorities.DIS.toString().intern()){
            bonus *= 2 ;
            Log.i("GAREHN_DISTANCE","Priority : point bonus");
        }

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