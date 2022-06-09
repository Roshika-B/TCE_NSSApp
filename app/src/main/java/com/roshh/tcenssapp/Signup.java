package com.roshh.tcenssapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    EditText vName, vAge, vEmail, vPw, vMobile, vBloodg;
    RadioButton vMale, vFemale;
    Button register;
    FirebaseAuth fAuth;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        tv=(TextView)findViewById(R.id.textView3);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intnt=new Intent(Signup.this,Login.class);
                startActivity(intnt);
                finish();
            }
        });
        vName=(EditText)findViewById(R.id.editTextTextPersonName);
        vAge=(EditText)findViewById(R.id.editTextNumber);
        vEmail=(EditText)findViewById(R.id.editTextTextEmailAddress);
        vPw=(EditText)findViewById(R.id.editTextPassword);
        vMobile=(EditText)findViewById(R.id.editTextPhone);
        vBloodg=(EditText)findViewById(R.id.editTextBloodgrp);
        vMale=(RadioButton)findViewById(R.id.radioButton);
        vFemale=(RadioButton)findViewById(R.id.radioButton2);
        register=(Button)findViewById(R.id.button3);

        fAuth=FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=vEmail.getText().toString().trim();
                String pw=vPw.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    vEmail.setError("Email is rewuired!");
                    return;
                }
                if(TextUtils.isEmpty(pw)){
                    vPw.setError("Password is required!");
                    return;
                }
                if(pw.length()<6){
                    vPw.setError("Password must be >= 6 characters!");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(email,pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent i=new Intent(Signup.this,Login.class);
                            startActivity(i);
                            finish();
                            Toast.makeText(getApplicationContext(),"User created",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(),"Error! "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}