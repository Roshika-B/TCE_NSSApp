package com.roshh.tcenssapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardNonVol extends AppCompatActivity {
    Button gbtn,bbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_non_vol);
        getSupportActionBar().hide();
        gbtn=(Button)findViewById(R.id.galbtn);
        gbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intnt=new Intent(DashboardNonVol.this,Gallery.class);
                startActivity(intnt);
//                finish();
            }
        });
        bbtn=(Button)findViewById(R.id.bosbtn);
        bbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DashboardNonVol.this,Bos.class);
                startActivity(i);
//                finish();
            }
        });

    }
}