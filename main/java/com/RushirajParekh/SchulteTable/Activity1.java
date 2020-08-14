package com.RushirajParekh.SchulteTable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import java.util.Objects;

public class Activity1 extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onPause() {
        super.onPause();
        mp.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mp.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mp = MediaPlayer.create(this, R.raw.main_track);
        mp.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

    }

    public void onHighScore(View view) {
        Intent i = new Intent(Activity1.this, HighScore.class);
        startActivity(i);
    }


    public void onNext1(View view) {
        Intent i = new Intent(Activity1.this, Activity4c4.class);
        startActivity(i);
    }

    public void onNext2(View view) {
        Intent i = new Intent(Activity1.this, Activity5c5.class);
        startActivity(i);
    }

    public void onNext3(View view) {
        Intent i = new Intent(Activity1.this, Activity6c6.class);
        startActivity(i);
    }

    public void onNext4(View view) {
        Intent i = new Intent(Activity1.this, ExtraHard.class);
        startActivity(i);
    }
}