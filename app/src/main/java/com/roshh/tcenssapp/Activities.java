package com.roshh.tcenssapp;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Activities extends AppCompatActivity {
    ListView ls;
    AdaptList adapt;
    String aMain[]={"Classroom Activity", "Cancer day awareness", "Field Activity", "Cyclathon", "Blood donation camp", "Trekking","Alumni meet"};
    String aExp[]={"Classroom Activity for junior volunteers",
    "Cancer day awareness programme to students",
    "NSS Cell cleaning activity junior volunteers",
    "Coordinating and participating in cyclathon 2022",
    "Overall college level blood donation camp",
    "Trekking to Thiruparankundram hill",
    "Volunteers and Alumni interaction meet"};
    int imgs[]={R.drawable.i1,R.drawable.i7,R.drawable.i12,R.drawable.i18,R.drawable.i7,R.drawable.i25,R.drawable.i27};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        getSupportActionBar().hide();
        ls=(ListView)findViewById(R.id.lstvw);
        adapt = new AdaptList(this,this.aMain,this.aExp,this.imgs);
        ls.setAdapter(adapt);
    }
}