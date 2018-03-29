package com.example.surji.androidservices;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.surji.androidservices.Service2.MyBinder;

public class MainActivity extends AppCompatActivity {

    Service2 service2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        Intent i = new Intent(this, Service2.class);
        bindService(i, sc, Context.BIND_AUTO_CREATE);
    }


    ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Toast.makeText(MainActivity.this, "Service is connected", Toast.LENGTH_SHORT).show();
            MyBinder myBinder = (MyBinder) iBinder;
            service2 = myBinder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Toast.makeText(MainActivity.this, "Service is disconnected", Toast.LENGTH_SHORT).show();
        }
    };


    public void dothis(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.startServ:
                Intent i1 = new Intent(this, Service1.class);
                startService(i1);
                break;
            case R.id.stopServ:
                Intent i2 = new Intent(this, Service1.class);
                stopService(i2);
                break;
            case R.id.boundServ:
                textView.setText(service2.getTime());
                break;
            case R.id.unbindServ:
                unbindService(sc);
                break;
            case R.id.intentServ:
                Intent i3 = new Intent(this, Service3.class);
                Bundle b = new Bundle();
                b.putInt("K1", 111);
                i3.putExtras(b);
                startService(i3);
                break;
            default:
                break;
        }
    }

}
