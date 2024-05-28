package com.amx.module;

import com.ads.amx.admob.Admob;
import com.ads.amx.admob.AppOpenManager;
import com.ads.amx.ads.AmxAd;
import com.ads.amx.application.AdsMultiDexApplication;
import com.ads.amx.applovin.AppLovin;
import com.ads.amx.applovin.AppOpenMax;
import com.ads.amx.billing.AppPurchase;
import com.ads.amx.config.AdjustConfig;
import com.ads.amx.config.AmxAdConfig;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends AdsMultiDexApplication {
    private final String APPSFLYER_TOKEN = "";
    private final String ADJUST_TOKEN = "";
    private final String EVENT_PURCHASE_ADJUST = "";
    private final String EVENT_AD_IMPRESSION_ADJUST = "";
    private static MyApplication context;

    public static MyApplication getApplication() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Admob.getInstance().setNumToShowAds(0);

        initBilling();
        initAds();

    }

    private void initAds() {
        String environment = BuildConfig.env_dev ? AmxAdConfig.ENVIRONMENT_DEVELOP : AmxAdConfig.ENVIRONMENT_PRODUCTION;
        amxAdConfig = new AmxAdConfig(this, environment);

        AdjustConfig adjustConfig = new AdjustConfig(true, ADJUST_TOKEN);
        adjustConfig.setEventAdImpression(EVENT_AD_IMPRESSION_ADJUST);
        adjustConfig.setEventNamePurchase(EVENT_PURCHASE_ADJUST);
        amxAdConfig.setAdjustConfig(adjustConfig);
        amxAdConfig.setAdjustTokenTiktok("123545");


        amxAdConfig.setIdAdResume(BuildConfig.ads_open_app);

        listTestDevice.add("EC25F576DA9B6CE74778B268CB87E431");
        amxAdConfig.setListDeviceTest(listTestDevice);
        amxAdConfig.setIntervalInterstitialAd(15);

        AmxAd.getInstance().init(this, amxAdConfig, false);

        Admob.getInstance().setDisableAdResumeWhenClickAds(true);
        AppLovin.getInstance().setDisableAdResumeWhenClickAds(true);
        Admob.getInstance().setOpenActivityAfterShowInterAds(true);
        AppOpenManager.getInstance().disableAppResumeWithActivity(SplashActivity.class);
        AppOpenMax.getInstance().disableAppResumeWithActivity(SplashActivity.class);
    }

    private void initBilling() {
        List<String> listINAPId = new ArrayList<>();
        List<String> listSubsId = new ArrayList<>();
        AppPurchase.getInstance().initBilling(getApplication(), listINAPId, listSubsId);
    }

}
