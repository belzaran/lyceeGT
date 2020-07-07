package com.garehn.lyceesgt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonStart;
    private static final int GAME_ACTIVITY_REQUEST_CODE = 0;
    private Toolbar toolbar;
    private ImageView closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.main_menu);
        setSupportActionBar(toolbar);

        closeButton=findViewById(R.id.menu_button_close);
        closeButton.setOnClickListener(this);

        Log.i("GAREHN_MAIN", "------------------------");
        Log.i("GAREHN_MAIN", "* Starting application Lycees GT");
        Log.i("GAREHN_MAIN", "------------------------");

        buttonStart = this.findViewById(R.id.main_button_start);
        buttonStart.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if(v == buttonStart) {
            Intent activity = new Intent(MainActivity.this, PriorityActivity.class);
            startActivityForResult(activity, GAME_ACTIVITY_REQUEST_CODE);
        }
        else if(v == closeButton){
           finish();
        }
    }
}



