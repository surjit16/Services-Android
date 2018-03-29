package com.example.surji.androidservices;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by surji on 26-03-2018.
 */

public class Service1 extends Service {
    public Service1() {
    }

    MediaPlayer mediaPlayer;
    int count = 0;

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show();
        mediaPlayer = MediaPlayer.create(this, R.raw.meri_jaan);
        mediaPlayer.setLooping(false);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service is Running", Toast.LENGTH_SHORT).show();
        mediaPlayer.start();

      /*  int count = 0;
        synchronized (this) {
            while (count < 10) {
                count++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }*/
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
