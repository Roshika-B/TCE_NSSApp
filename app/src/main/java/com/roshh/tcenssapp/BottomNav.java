package com.roshh.tcenssapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.roshh.tcenssapp.databinding.ActivityMainBinding;

public class BottomNav extends AppCompatActivity {
    BottomNavigationView bn1;

    FirebaseAuth fAuth;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_bottom_nav);
        bn1 = findViewById(R.id.btmnavg);
        bn1.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.flay,new HomeFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =new BottomNavigationView.OnNavigationItemSelectedListener(){

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedfragment = null;
            switch (item.getItemId()) {

                case R.id.nhome:
                    selectedfragment = new HomeFragment();
                    break;
                case R.id.nabtus:
                    selectedfragment=new AboutusFragment();
                    break;
                case R.id.nlgout:
                    fAuth.signOut();
                    Intent i = new Intent(BottomNav.this, Page1.class);
                    startActivity(i);
                    finish();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.flay,selectedfragment).commit();
            return true;
        }
    };
}