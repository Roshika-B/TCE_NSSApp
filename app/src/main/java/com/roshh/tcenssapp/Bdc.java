package com.roshh.tcenssapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class Bdc extends AppCompatActivity {
    Button btn;
    //final EditText etname, etage, etmobile, etbloodgrp, ethosp;
    String bloodgrp,ad;

//    public Bdc(EditText etname, EditText etage, EditText etmobile, EditText etbloodgrp, EditText ethosp) {
//        this.etname = etname;
//        this.etage = etage;
//        this.etmobile = etmobile;
//        this.etbloodgrp = etbloodgrp;
//        this.ethosp = ethosp;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdc);
        getSupportActionBar().hide();
        final EditText etage=findViewById(R.id.editTextNumber);
        final EditText etmobile=findViewById(R.id.editTextPhone);
        final EditText etbloodgrp=findViewById(R.id.editTextBloodgrp);
        final EditText ethosp=findViewById(R.id.editTextName);
        final EditText etname=(EditText)findViewById(R.id.editTextTextPersonName);
        DAOPatientDetail dao = new DAOPatientDetail();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("mych", "My notif", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        btn=(Button)findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edage=etage.getText().toString();
                int etinage = Integer.parseInt(edage);
                PatientDetail pat=new PatientDetail(etname.getText().toString(),etinage,etmobile.getText().toString(),etbloodgrp.getText().toString(),ethosp.getText().toString());
                dao.add(pat).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        ad=etbloodgrp.getText().toString();
                        bloodgrp="Emergency! Help the needy! "+ad;
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(Bdc.this, "mych");
                        builder.setContentTitle("NSS App");
                        builder.setSmallIcon(R.drawable.bdimg);
                        builder.setContentText(bloodgrp);
                        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(Bdc.this);
                        managerCompat.notify(1, builder.build());
                        Toast.makeText(getApplicationContext(),"Hope for the best!",Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @org.jetbrains.annotations.NotNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                });
//                ad=etbloodgrp.getText().toString();
//                bloodgrp="Emergency! Help the needy! "+ad;
//                NotificationCompat.Builder builder = new NotificationCompat.Builder(Bdc.this, "mych");
//                builder.setContentTitle("NSS App");
//                builder.setSmallIcon(R.drawable.bdimg);
//                builder.setContentText(bloodgrp);
//                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(Bdc.this);
//                managerCompat.notify(1, builder.build());
//                Toast.makeText(getApplicationContext(),"Hope for the best!",Toast.LENGTH_LONG).show();
            }
        });
    }
}