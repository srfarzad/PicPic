package com.picpic.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.picpic.PicPicInterface;
import com.picpic.Profile.Menu.SignUpActivity;
import com.picpic.RequestCallback;

public class PicPicService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    private final PicPicInterface.Stub mBinder = new PicPicInterface.Stub() {
        @Override
        public void newService() throws RemoteException {
            Log.e("","");
        }

        @Override
        public void login(String params, RequestCallback callback) throws RemoteException {
            Log.e("","");
            new Intent(getApplicationContext(),SignUpActivity.class);

        }

        @Override
        public void startApp(String params) throws RemoteException {
            Log.e("","");
        }
    };
}
