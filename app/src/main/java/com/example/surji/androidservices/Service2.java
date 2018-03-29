package com.example.surji.androidservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by surji on 26-03-2018.
 */

public class Service2 extends Service {

    public Service2() {
    }

    IBinder iBinder = new Service2.MyBinder();

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "in OnBind of Bound Service", Toast.LENGTH_SHORT).show();
        return iBinder;
    }

    public String getTime() {

        Date d = new Date();
        return d.toString();
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "in OnCreate of Bound Service", Toast.LENGTH_SHORT).show();
    }

    class MyBinder extends Binder {
        Service2 getService() {
            return Service2.this;
        }
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "in On Destroy of Bound Service", Toast.LENGTH_SHORT).show();
    }
}
