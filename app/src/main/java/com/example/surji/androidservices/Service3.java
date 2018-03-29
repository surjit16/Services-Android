package com.example.surji.androidservices;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by surji on 26-03-2018.
 */

public class Service3 extends IntentService {

    public Service3() {
        super("To call parent class constructor");
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Intent Service Created", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(this, "Intent Service started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int count = 0;
        synchronized (this) {
            while (count < 10) {
                Log.d("Hello", "Inside nHandleIntent");
                count++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
