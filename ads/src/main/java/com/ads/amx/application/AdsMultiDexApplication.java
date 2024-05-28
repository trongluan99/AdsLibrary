package com.ads.amx.application;

import androidx.multidex.MultiDexApplication;

import com.ads.amx.config.AmxAdConfig;
import com.ads.amx.util.AppUtil;
import com.ads.amx.util.SharePreferenceUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class AdsMultiDexApplication extends MultiDexApplication {

    protected AmxAdConfig amxAdConfig;
    protected List<String> listTestDevice ;
    @Override
    public void onCreate() {
        super.onCreate();
        listTestDevice = new ArrayList<String>();
        amxAdConfig = new AmxAdConfig(this);
        if (SharePreferenceUtils.getInstallTime(this) == 0) {
            SharePreferenceUtils.setInstallTime(this);
        }
        AppUtil.currentTotalRevenue001Ad = SharePreferenceUtils.getCurrentTotalRevenue001Ad(this);
    }


}
