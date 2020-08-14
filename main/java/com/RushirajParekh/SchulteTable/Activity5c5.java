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
//import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Objects;
import java.util.Random;

public class Activity5c5 extends AppCompatActivity {

    private Chronometer chrono5c5;
    public int cur5 = 1;
    TextView inst5;
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

        chrono5c5 = findViewById(R.id.chrono5c5);
        mp = MediaPlayer.create(this,R.raw.medium_track);
        mp.start();
        mp.setLooping(true);
        inst5 = findViewById(R.id.instruction5c5);
        beep = MediaPlayer.create(this, R.raw.beep4);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5c5);

        /*  adMob COE   */
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        /*  adMob CODE end  */



        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        newSchulte5c5();
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

        if(((TextView)v).getText().toString().equals(""+cur5)) {
            inst5.setText("Next : " + (cur5+1));

            if(cur5 == 1) {
                chrono5c5.setBase(SystemClock.elapsedRealtime());
                chrono5c5.start();
            }
            if(cur5 == 25) {
                inst5.setText("YOU WON");
                chrono5c5.stop();
//                Toast.makeText(Activity5c5.this, "YOU WON", Toast.LENGTH_SHORT).show();
                String onChrono = chrono5c5.getContentDescription().toString();
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
                HighScoreStore.s51 = Math.max((500 - seconds), HighScoreStore.s51);
            }
            cur5++;
        } else {
            chrono5c5.stop();
            inst5.setText("GAME OVER");
//            Toast.makeText(Activity5c5.this, "GAME OVER", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("SetTextI18n")
    public void onRefresh(View view) {
        chrono5c5.stop();
        chrono5c5.setBase(SystemClock.elapsedRealtime());
        inst5.setText("Tap 1 to start");
        cur5 = 1;
        newSchulte5c5();
    }

    void newSchulte5c5() {

        cur5 = 1;
        TextView[]t = new TextView[25];

        t[0] = findViewById(R.id.n5_1);
        t[1] = findViewById(R.id.n5_2);
        t[2] = findViewById(R.id.n5_3);
        t[3] = findViewById(R.id.n5_4);
        t[4] = findViewById(R.id.n5_5);
        t[5] = findViewById(R.id.n5_6);
        t[6] = findViewById(R.id.n5_7);
        t[7] = findViewById(R.id.n5_8);
        t[8] = findViewById(R.id.n5_9);
        t[9] = findViewById(R.id.n5_10);
        t[10] = findViewById(R.id.n5_11);
        t[11] = findViewById(R.id.n5_12);
        t[12] = findViewById(R.id.n5_13);
        t[13] = findViewById(R.id.n5_14);
        t[14] = findViewById(R.id.n5_15);
        t[15] = findViewById(R.id.n5_16);
        t[16] = findViewById(R.id.n5_17);
        t[17] = findViewById(R.id.n5_18);
        t[18] = findViewById(R.id.n5_19);
        t[19] = findViewById(R.id.n5_20);
        t[20] = findViewById(R.id.n5_21);
        t[21] = findViewById(R.id.n5_22);
        t[22] = findViewById(R.id.n5_23);
        t[23] = findViewById(R.id.n5_24);
        t[24] = findViewById(R.id.n5_25);

        Random rand = new Random();

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