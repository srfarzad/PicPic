package com.picpic.config;

import android.app.Application;

import io.realm.Realm;

public class AppConfig extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
    }
}
