package com.roshh.tcenssapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Page1 extends AppCompatActivity {
    Button volbt, nonvolbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        getSupportActionBar().hide();
        volbt=(Button)findViewById(R.id.volbut);
        volbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page1.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
        nonvolbt=(Button)findViewById(R.id.nonvolbut);
        nonvolbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Page1.this,DashboardNonVol.class);
                startActivity(i);
                finish();
            }
        });
    }
}