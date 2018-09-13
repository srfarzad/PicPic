package com.picpic.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;

public class UpdateService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        MediaPlayer mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource("https://upload.wikimedia.org/wikipedia/en/8/84/Pearson%2C_Kirk-_%22Going_Up%22.ogg");
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // mediaPlayer.setLooping(true);
        mediaPlayer.start();

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
