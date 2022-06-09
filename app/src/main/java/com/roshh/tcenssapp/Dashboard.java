package com.roshh.tcenssapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {
    CardView home, attendance, bos, gallery, abtus, activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();
        home=(CardView)findViewById(R.id.cardHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Dashboard.this,Dashboard.class);
                startActivity(i);
                finish();
            }
        });
        attendance=(CardView)findViewById(R.id.cardAttend);
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Dashboard.this,Attendance.class);
                startActivity(i);
                finish();
            }
        });
        bos=(CardView)findViewById(R.id.cardBos);
        bos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Dashboard.this,Bos.class);
                startActivity(i);
                finish();
            }
        });
        gallery=(CardView)findViewById(R.id.cardGall);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Dashboard.this,Gallery.class);
                startActivity(i);
                finish();
            }
        });
        abtus=(CardView)findViewById(R.id.cardAbt);
        abtus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Dashboard.this,Dashboard.class);
                startActivity(i);
                finish();
            }
        });
        activity=(CardView)findViewById(R.id.cardActiv);
        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Dashboard.this,Activities.class);
                startActivity(i);
                finish();
            }
        });
    }
}