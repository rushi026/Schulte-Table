package com.RushirajParekh.SchulteTable;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Objects;
import java.util.Random;

public class Activity6c6 extends AppCompatActivity {

    private Chronometer chrono;
    public int cur6 = 1;
    private AdView mAdView;
    TextView inst6;
    MediaPlayer mp, beep;

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

        mp = MediaPlayer.create(this,R.raw.hard_track);
        mp.start();
        mp.setLooping(true);
        beep = MediaPlayer.create(this, R.raw.beep7);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6c6);

        /*  adMob COE   */
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        /*  adMob CODE end  */


        inst6 = findViewById(R.id.instruction6c6);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        newSchulte();
    }



    public void onRefresh(View view) {
        chrono.stop();
        chrono.setBase(SystemClock.elapsedRealtime());
        inst6.setText("Tap 1 to start");
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

    public void onTap(View v) {
        beep.start();
        if(((TextView)v).getText().toString().equals(""+cur6)) {
            inst6.setText("Next : " + (cur6+1));
            if(cur6 == 1) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
            }
            if(cur6 == 36) {
                inst6.setText("YOU WON");
                chrono.stop();
//                Toast.makeText(this, "You won", Toast.LENGTH_SHORT).show();

                String onChrono = chrono.getContentDescription().toString();
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

                HighScoreStore.s61 = Math.max((500 - seconds), HighScoreStore.s61);
            }
            cur6++;
        }
        else {
            inst6.setText("GAME OVER");
//            Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show();
            chrono.stop();
        }
    }

    void newSchulte() {
        chrono = findViewById(R.id.chrono);
        cur6 = 1;
        TextView[]t = new TextView[36];

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
        t[25] = findViewById(R.id.n26);
        t[26] = findViewById(R.id.n27);
        t[27] = findViewById(R.id.n28);
        t[28] = findViewById(R.id.n29);
        t[29] = findViewById(R.id.n30);
        t[30] = findViewById(R.id.n31);
        t[31] = findViewById(R.id.n32);
        t[32] = findViewById(R.id.n33);
        t[33] = findViewById(R.id.n34);
        t[34] = findViewById(R.id.n35);
        t[35] = findViewById(R.id.n36);

        Random rand = new Random();

        int []num = new int[36];
        int n = 1;
        do {
            int random = rand.nextInt(36);
            if(num[random] == 0) {
                num[random] = n;
                t[random].setText(String.valueOf(n));
                n++;
            }
        }while (n != 37);
    }

}