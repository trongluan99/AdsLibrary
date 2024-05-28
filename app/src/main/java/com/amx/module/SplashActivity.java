package com.amx.module;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ads.amx.admob.AppOpenManager;
import com.ads.amx.funtion.AdCallback;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        AppOpenManager.getInstance().loadAdOpenSplash2id(SplashActivity.class, this,
                "ca-app-pub-3940256099942544/9257395921",
                "ca-app-pub-3940256099942544/9257395921", 25000, new AdCallback() {
                    @Override
                    public void onNextAction() {
                        super.onNextAction();
                    }
                });
    }
}