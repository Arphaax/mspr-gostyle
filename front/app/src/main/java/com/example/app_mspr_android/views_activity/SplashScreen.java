package com.example.app_mspr_android.views_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import com.example.app_mspr_android.R;

public class SplashScreen extends Activity {

    private static int SPLASH_TIME_OUT = 3000;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new  Intent(SplashScreen.this, LoginActivity.class);
                SplashScreen.this.startActivity(i);
                SplashScreen.this.finish();

            }
        },SPLASH_TIME_OUT);
    }
}
