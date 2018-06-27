package com.praveen.pilani.freeinternetapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class InternetData extends AppCompatActivity {

    private static final String TAG = "InternetData";
    TextView tv;
    CardView cv;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internet_data);

        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, "ca-app-pub-7152815429504851~7360705844");

        // Create the InterstitialAd and set the adUnitId.
        interstitialAd = new InterstitialAd(this);
        // Defined in res/values/strings.xml
        interstitialAd.setAdUnitId("ca-app-pub-7152815429504851/2822695030");

        startGame();

       String text= getIntent().getStringExtra("text");

       cv = findViewById(R.id.cv);

        tv = findViewById(R.id.tv);
       tv.setText(text);

       cv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               showInterstitial();
           }
       });


        interstitialAd.setAdListener(new AdListener(){

            @Override
            public void onAdClosed() {
                Log.d(TAG,"onAddClosed Executed");
                // Code to be executed when when the interstitial ad is closed.
                Intent intent = new Intent(getApplicationContext(),Connected.class);
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
