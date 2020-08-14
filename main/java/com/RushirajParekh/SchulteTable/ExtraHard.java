package com.RushirajParekh.SchulteTable;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.TextView;


import java.util.Objects;
import java.util.Random;

public class ExtraHard extends AppCompatActivity {

    private Chronometer chronoExtraHard;
    public int curExtraHard = 1;
    TextView instExtraHard;
    MediaPlayer mp, beep;
    Random rand;

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_hard);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        chronoExtraHard = findViewById(R.id.chronoExtraHard);
        instExtraHard = findViewById(R.id.instructionExtraHard);
        mp = MediaPlayer.create(this,R.raw.medium_track);
        mp.start();
        mp.setLooping(true);

        beep = MediaPlayer.create(this, R.raw.beep4);

        /*  adMob COE   */
//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//            }
//        });
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
        /*  adMob CODE end  */

        curExtraHard = 1;
        newSchulte();
    }

    static String stringToNum(String str) {
        str = str.replaceAll("[^\\d]", " ");
        str = str.trim();
        str = str.replaceAll(" +", " ");
        if (str.equals(""))
            return "-1";
        return str;
    }


    @SuppressLint("SetTextI18n")
    public void onTap(View v) {
        beep.start();

        if(((TextView)v).getText().toString().equals(""+curExtraHard)) {
            instExtraHard.setText("Next : " + (curExtraHard+1));


            if(curExtraHard == 1) {
                chronoExtraHard.setBase(SystemClock.elapsedRealtime());
                chronoExtraHard.start();
            }

            else if(curExtraHard == 25) {
                curExtraHard = 1;
                instExtraHard.setText("YOU WON");
                chronoExtraHard.stop();
                String onChrono = chronoExtraHard.getContentDescription().toString();
                onChrono = stringToNum(onChrono);
                int seconds = 0;
                if(onChrono.length() > 2) {
                    String[] time = onChrono.split(" ");
                    int[] timeInNum = new int[2];
                    timeInNum[0] = Integer.parseInt(time[0]);
                    timeInNum[1] = Integer.parseInt(time[1]);
                    if(timeInNum[0] > 0) {
                        seconds += (timeInNum[0]*60);
                    }
                    seconds += timeInNum[1];
                }
                else {
                    seconds += Integer.parseInt(onChrono);
                }
                HighScoreStore.sEH = Math.max((500 - seconds), HighScoreStore.sEH);
            }
            curExtraHard++;
            newSchulte();
        }
        else {
            chronoExtraHard.stop();
            instExtraHard.setText("GAME OVER");
//            Toast.makeText(Activity5c5.this, "GAME OVER", Toast.LENGTH_SHORT).show();
        }
    }



    @SuppressLint("SetTextI18n")
    public void onRefresh(View view) {
        chronoExtraHard.stop();
        chronoExtraHard.setBase(SystemClock.elapsedRealtime());
        instExtraHard.setText("Tap 1 to start");
        curExtraHard = 1;
        newSchulte();
    }

    void newSchulte() {

        TextView[]t = new TextView[25];

        t[0] = findViewById(R.id.n1);
        t[1] = findViewById(R.id.n2);
        t[2] = findViewById(R.id.n3);
        t[3] = findViewById(R.id.n4);
        t[4] = findViewById(R.id.n5);
        t[5] = findViewById(R.id.n6);
        t[6] = findViewById(R.id.n7);
        t[7] = findViewById(R.id.n8);
        t[8] = findViewById(R.id.n9);
        t[9] = findViewById(R.id.n10);
        t[10] = findViewById(R.id.n11);
        t[11] = findViewById(R.id.n12);
        t[12] = findViewById(R.id.n13);
        t[13] = findViewById(R.id.n14);
        t[14] = findViewById(R.id.n15);
        t[15] = findViewById(R.id.n16);
        t[16] = findViewById(R.id.n17);
        t[17] = findViewById(R.id.n18);
        t[18] = findViewById(R.id.n19);
        t[19] = findViewById(R.id.n20);
        t[20] = findViewById(R.id.n21);
        t[21] = findViewById(R.id.n22);
        t[22] = findViewById(R.id.n23);
        t[23] = findViewById(R.id.n24);
        t[24] = findViewById(R.id.n25);

        rand = new Random();

        int []num = new int[25];
        int n = 1;
        do {
            int random = rand.nextInt(25);
            if(num[random] == 0) {
                num[random] = n;
                t[random].setText(String.valueOf(n));
                n++;
            }
        }while (n != 26);
    }
}