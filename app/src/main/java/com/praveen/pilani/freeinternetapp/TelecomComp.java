package com.praveen.pilani.freeinternetapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class TelecomComp extends AppCompatActivity {

    private static final String TAG = "TelecomComp";
    TextView airtel,vodafone,chinamobile,claro,jio,bsnl,chinaunicom,movistar,chinatelecom,veon,mtn,orange,tel,tmobile,stc,eti,
    att,mts,tim,others;
    private InterstitialAd interstitialAd;
    private CountDownTimer countDownTimer;
    private Button retryButton;
    private boolean gameIsInProgress;
    private long timerMilliseconds;
    String text = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telecom_comp);


        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, "ca-app-pub-7152815429504851~7360705844");

        // Create the InterstitialAd and set the adUnitId.
        interstitialAd = new InterstitialAd(this);
        // Defined in res/values/strings.xml
        interstitialAd.setAdUnitId("ca-app-pub-7152815429504851/2822695030");

        startGame();

        airtel = findViewById(R.id.airtel);
        vodafone = findViewById(R.id.vodafone);
        chinamobile = findViewById(R.id.chinamobile);
        claro = findViewById(R.id.claro);
        jio = findViewById(R.id.jio);
        bsnl = findViewById(R.id.bsnl);
        chinaunicom = findViewById(R.id.chinaunicom);
        movistar = findViewById(R.id.movistar);
        chinatelecom = findViewById(R.id.chinatelecom);
        veon = findViewById(R.id.veon);
        mtn = findViewById(R.id.mtn);
        orange = findViewById(R.id.orange);
        tel = findViewById(R.id.tel);
        tmobile = findViewById(R.id.tmobile);
        stc = findViewById(R.id.stc);
        eti = findViewById(R.id.eti);
        att = findViewById(R.id.att);
        mts = findViewById(R.id.mts);
        tim = findViewById(R.id.tim);
        others = findViewById(R.id.others);


        airtel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 text= airtel.getText().toString();
                showInterstitial();
            }
        });

        vodafone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= vodafone.getText().toString();
                showInterstitial();
            }
        });

        chinamobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= chinamobile.getText().toString();
                showInterstitial();
            }
        });


        claro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= claro.getText().toString();
                showInterstitial();
            }
        });

        jio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= jio.getText().toString();
                showInterstitial();
            }
        });

        bsnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= bsnl.getText().toString();
                showInterstitial();
            }
        });

        chinaunicom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= chinaunicom.getText().toString();
                showInterstitial();
            }
        });

        movistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= movistar.getText().toString();
                showInterstitial();
            }
        });

        chinatelecom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= chinatelecom.getText().toString();
                showInterstitial();
            }
        });

        veon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= veon.getText().toString();
                showInterstitial();
            }
        });

        mtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= mtn.getText().toString();
                showInterstitial();
            }
        });

        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= orange.getText().toString();
                showInterstitial();
            }
        });

        tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= tel.getText().toString();
                showInterstitial();
            }
        });

        tmobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= tmobile.getText().toString();
                showInterstitial();
            }
        });

        stc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= stc.getText().toString();
                showInterstitial();
            }
        });

        eti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= eti.getText().toString();
                showInterstitial();
            }
        });

        att.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= att.getText().toString();
                showInterstitial();
            }
        });

        mts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= mts.getText().toString();
                showInterstitial();
            }
        });

        tim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= tim.getText().toString();
                showInterstitial();
            }
        });

        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= others.getText().toString();
                showInterstitial();
            }
        });


        interstitialAd.setAdListener(new AdListener(){

            @Override
            public void onAdClosed() {
                Log.d(TAG,"onAddClosed Executed");
                // Code to be executed when when the interstitial ad is closed.
                Intent intent = new Intent(getApplicationContext(),InternetData.class);
                intent.putExtra("text",text);
                startActivity(intent);
            }
        });
    }


    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and restart the game.
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            Toast.makeText(this, "Your Internet is not Working", Toast.LENGTH_SHORT).show();
            startGame();
        }
    }

    private void startGame() {
        // Request a new ad if one isn't already loaded, hide the button, and kick off the timer.
        if (!interstitialAd.isLoading() && !interstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder().build();
            interstitialAd.loadAd(adRequest);
        }

      //  retryButton.setVisibility(View.INVISIBLE);

    }




}
