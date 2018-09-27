package com.picpic.config;

import android.app.Application;

import com.onesignal.OneSignal;

import io.realm.Realm;

public class AppConfig extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();


    }
}
