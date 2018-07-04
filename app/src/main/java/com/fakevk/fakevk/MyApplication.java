package com.fakevk.fakevk;

import android.app.Application;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);

    }
}

