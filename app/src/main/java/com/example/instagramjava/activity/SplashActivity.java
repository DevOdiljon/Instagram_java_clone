package com.example.instagramjava.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.example.instagramjava.R;

/**
 * In SplashActivity, user can visit to SignInActivity or MainActivity
 */

public class SplashActivity extends BaseActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initViews();
    }

    private void initViews() {
        countDownTimer();
    }

    private void countDownTimer() {
        new CountDownTimer(2000, 1000){

            @Override
            public void onTick(long millisUntilFinished) { }

            @Override
            public void onFinish() {
                callSignInActivity();
            }
        }.start();
    }

    private void callSignInActivity() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }
}