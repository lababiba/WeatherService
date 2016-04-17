package com.example.lababiba.weatherservice.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by lababiba on 14.04.16.
 */
public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ServiceTask();
        return super.onStartCommand(intent, flags, startId);
    }

    private void ServiceTask() {
        Toast.makeText(this,"Service started",Toast.LENGTH_SHORT).show();
    }
}
