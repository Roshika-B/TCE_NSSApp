package com.roshh.tcenssapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class Gallery extends AppCompatActivity {
    GridView gridview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        getSupportActionBar().hide();
        gridview = (GridView)findViewById(R.id.grid_view);
        gridview.setAdapter(new ImageAdapter(this));
    }
}