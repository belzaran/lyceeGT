package com.garehn.lyceesgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button buttonStart;
    private static final int GAME_ACTIVITY_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("GAREHN_MAIN", "------------------------");
        Log.i("GAREHN_MAIN", "* Starting application Lycees GT");
        Log.i("GAREHN_MAIN", "------------------------");

        buttonStart = this.findViewById(R.id.main_button_start);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent distanceActivity = new Intent(MainActivity.this, DistanceActivity.class);
                startActivityForResult(distanceActivity, GAME_ACTIVITY_REQUEST_CODE);
            }
        });
    }



}
