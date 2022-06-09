package com.roshh.tcenssapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bdc extends AppCompatActivity {
    Button btn;
    EditText ed1;
    String bloodgrp,ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdc);
        getSupportActionBar().hide();
        ed1=(EditText)findViewById(R.id.editTextBloodgrp);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("mych", "My notif", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        btn=(Button)findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad=ed1.getText().toString();
                bloodgrp="Emergency! Help the needy! "+ad;
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Bdc.this, "mych");
                builder.setContentTitle("NSS App");
                builder.setSmallIcon(R.drawable.bdimg);
                builder.setContentText(bloodgrp);
                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(Bdc.this);
                managerCompat.notify(1, builder.build());
                Toast.makeText(getApplicationContext(),"Hope for the best!",Toast.LENGTH_LONG).show();
            }
        });
    }
}