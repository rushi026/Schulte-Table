package com.RushirajParekh.SchulteTable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Objects;


public class HighScore extends AppCompatActivity {

    TextView hs4, hs5, hs6, hsEH;
    MediaPlayer mp;

    public static final String SHARED_PREFERENCE = "sharedPreference";
    public static final String HS4 = "4";
    public static final String HS5 = "5";
    public static final String HS6 = "6";
    public static final String HSEH = "5";

    public int getFromSP4 = 0;
    public int getFromSP5 = 0;
    public int getFromSP6 = 0;
    public int getFromSPEH = 0;

    @Override
    protected void onResume() {
        super.onResume();
        mp.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mp = MediaPlayer.create(this, R.raw.main_track);
        mp.start();
        mp.setLooping(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        ImageButton back;
        back = findViewById(R.id.backButton);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HighScore.this, Activity1.class);
                startActivity(i);
                finish();
            }
        });

        hs4 = findViewById(R.id.hs4value);
        hs5 = findViewById(R.id.hs5value);
        hs6 = findViewById(R.id.hs6value);
        hsEH = findViewById(R.id.hsEHvalue);

        int cur4 =Integer.parseInt(hs4.getText().toString());
        int cur5 =Integer.parseInt(hs5.getText().toString());
        int cur6 =Integer.parseInt(hs6.getText().toString());
        int curEH = Integer.parseInt(hsEH.getText().toString());

        int newHigh4 = HighScoreStore.s41;
        int newHigh5 = HighScoreStore.s51;
        int newHigh6 = HighScoreStore.s61;
        int newHighEH = HighScoreStore.sEH;

        if(newHigh4 > cur4) {
            hs4.setText(String.valueOf(newHigh4));
        } else {
            Import4();
        }

        if(newHigh5 > cur5) {
            hs5.setText(String.valueOf(newHigh5));
        } else {
            Import5();
        }

        if(newHigh6 > cur6) {
            hs6.setText(String.valueOf(newHigh6));
        } else {
            Import6();
        }

        if(newHighEH > curEH) {
            hsEH.setText(String.valueOf(newHighEH));
        } else {
            ImportEH();
        }


    }

    public void Export() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(HS4, Integer.parseInt(hs4.getText().toString()));
        editor.putInt(HS5, Integer.parseInt(hs5.getText().toString()));
        editor.putInt(HS6, Integer.parseInt(hs6.getText().toString()));
        editor.apply();
    }

    public void Import4() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFERENCE, MODE_PRIVATE);
        getFromSP4 = sp.getInt(HS4,0);
        hs4.setText(String.valueOf(getFromSP4));
    }

    public void Import5() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFERENCE, MODE_PRIVATE);
        getFromSP5 = sp.getInt(HS5, 0);
        hs5.setText(String.valueOf(getFromSP5));
    }

    public void Import6() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFERENCE, MODE_PRIVATE);
        getFromSP6 = sp.getInt(HS6, 0);
        hs6.setText(String.valueOf(getFromSP6));
    }

    public void ImportEH() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFERENCE, MODE_PRIVATE);
        getFromSPEH = sp.getInt(HSEH, 0);
        hsEH.setText(String.valueOf(getFromSPEH));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Export();
        mp.stop();
    }

}