package com.example.stopwatch;


import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private long PauseOffSet = 0;
    private boolean isPlaying = false;
    private Button start_button;
    private Button stop_button;
    private Button reset_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Let's select our element
        chronometer = findViewById(R.id.chronometer);
        start_button= findViewById(R.id.buttonstart);
        stop_button = findViewById(R.id.buttonstop);
        reset_button = findViewById(R.id.buttonreset);

        start_button.setOnClickListener(v -> {
                    chronometer.setBase(SystemClock.elapsedRealtime()- PauseOffSet);
                    chronometer.start();
                    isPlaying = true;
        });


        stop_button.setOnClickListener(v -> {
                if(isPlaying){
                    chronometer.stop();
                    isPlaying = false;
                }
        });

        reset_button.setOnClickListener(v -> {
            chronometer.setBase(SystemClock.elapsedRealtime());
        });
    }
}