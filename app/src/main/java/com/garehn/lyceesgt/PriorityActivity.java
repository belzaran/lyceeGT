package com.garehn.lyceesgt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.renderscript.RenderScript;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.garehn.lyceesgt.lycees.Lycee;
import com.garehn.lyceesgt.lycees.Priorities;

import java.util.ArrayList;
import java.util.List;

public class PriorityActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int GAME_ACTIVITY_REQUEST_CODE = 1;


    private ArrayList<Priorities> priorities = new ArrayList<>();
    private ListView listPriorities;
    private Priorities priority;

    private Button buttonValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priority);
        Log.i("GAREHN_PRIORITY","  Connecting to PriorityActivity");
        addPriorities();
        createAssets();



    }

    public void addPriorities() {
        priorities.add(Priorities.SIZ);
        priorities.add(Priorities.RAN);
        priorities.add(Priorities.DIS);
        priorities.add(Priorities.SPE);
        priorities.add(Priorities.TEC);
        priorities.add(Priorities.LAN);
    }

    public void createAssets(){

        //LISTVIEW

        listPriorities = findViewById(R.id.priority_list);

        List priorityNames = new ArrayList();
        int size = priorities.size();
        for (int i =0;i<size;i++){
            priorityNames.add(priorities.get(i).toString());
        }

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                R.layout.text_priority_list,
                priorityNames
        );

        listPriorities.setAdapter(adapter);
        listPriorities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    view.setSelected(true);
                    selectItem(position);
                         }

        });

        //BUTTON
        buttonValidate = findViewById(R.id.priority_button_start);
        buttonValidate.setOnClickListener(this);

    }

    // get and save the selected item in listView
    public void selectItem(int p){
        priority = priorities.get(p);
    }

    @Override
    public void onClick(View v) {
        Log.i("GAREHN_PRIORITY"," Click");

        if(priority != null) {
            Log.i("GAREHN_PRIORITY", "RESULT : " + priority.toString());

            Intent activity = new Intent(PriorityActivity.this, DistanceActivity.class);

            activity.putExtra("priority", priority.toString());

            setResult(RESULT_OK, activity);
            startActivityForResult(activity, GAME_ACTIVITY_REQUEST_CODE);
        }
        else{
            sendMessage("ERREUR", "Veuillez choisir une priorité");
        }
    }

    public void sendMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //finish();
                    }
                })
                .create()
                .show();
    }
}