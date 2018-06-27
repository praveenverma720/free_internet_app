package com.praveen.pilani.freeinternetapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/**
 * Created by Prek on 31/05/2018.
 */

public class Connected extends AppCompatActivity implements RewardedVideoAdListener {

    private static final String TAG = "Connected";
    private static final String AD_UNIT_ID = "ca-app-pub-7152815429504851/9004960008";
    private static final String APP_ID = "ca-app-pub-7152815429504851~7360705844";

    private int coinCount;
    private TextView coinCountText;
    private RewardedVideoAd rewardedVideoAd;

    private CardView showVideoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connected);

        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, APP_ID);

        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();

        // Create the "show" button, which shows a rewarded video if one is loaded.
        showVideoButton = findViewById(R.id.more);
       // showVideoButton.setVisibility(View.INVISIBLE);
        showVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"1");
                showRewardedVideo();
            }
        });

        Log.d(TAG,"2");
        // Display current coin count to user.
        coinCountText = findViewById(R.id.data);
        coinCount = 0;
        coinCountText.setText(""+coinCount);

        startGame();


    }


    private void loadRewardedVideoAd() {
        if (!rewardedVideoAd.isLoaded()) {
            Log.d(TAG,"3");
            rewardedVideoAd.loadAd(AD_UNIT_ID, new AdRequest.Builder().build());
        }
    }

    private void addCoins(int coins) {

        Log.d(TAG,"4");
        coinCount += coins;
        coinCountText.setText(""+coinCount);
    }

    private void startGame() {
        // Hide the retry button, load the ad, and start the timer.
//        retryButton.setVisibility(View.INVISIBLE);
//        showVideoButton.setVisibility(View.INVISIBLE);
        Log.d(TAG,"5");
        loadRewardedVideoAd();

    }


    private void showRewardedVideo() {
       // showVideoButton.setVisibility(View.INVISIBLE);
        if (rewardedVideoAd.isLoaded()) {
            Log.d(TAG,"6");
            rewardedVideoAd.show();
        }
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
       // Toast.makeText(this, "onRewardedVideoAdLeftApplication", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdClosed() {
        Toast.makeText(this, "You Have Received 15 MB Data", Toast.LENGTH_SHORT).show();
        // Preload the next video ad.
       // loadRewardedVideoAd();
    }

    @Override
    public void onRewarded(RewardItem reward) {
        Log.d(TAG,"7");
        Toast.makeText(this,
                String.format(" onRewarded! currency: %s amount: %d", reward.getType(),
                        reward.getAmount()),
                Toast.LENGTH_SHORT).show();
        addCoins(reward.getAmount());
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {
        loadRewardedVideoAd();
        Log.d(TAG,"8");
       // Toast.makeText(this, "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        showRewardedVideo();
        Log.d(TAG,"9");
        Toast.makeText(this, "Click to get more Data", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdOpened() {
        Log.d(TAG,"10");
    //    Toast.makeText(this, "Internet Data Video Opened", Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onRewardedVideoStarted() {
        Log.d(TAG,"11");
     //   Toast.makeText(this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoCompleted() {
        Log.d(TAG,"12");
       // Toast.makeText(this, "onRewardedVideoCompleted", Toast.LENGTH_SHORT).show();
    }


}
