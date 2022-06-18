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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class Signup extends AppCompatActivity {
    Button register;
    FirebaseAuth fAuth;
//    FirebaseDatabase dbref;
//    DatabaseReference ref;
//    int i=0;
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
        final EditText vName=(EditText)findViewById(R.id.editTextTextPersonName);
        final EditText vAge=(EditText)findViewById(R.id.editTextNumber);
        final EditText vEmail=(EditText)findViewById(R.id.editTextTextEmailAddress);
        final EditText vPw=(EditText)findViewById(R.id.editTextPassword);
        final EditText vMobile=(EditText)findViewById(R.id.editTextPhone);
        final EditText vBloodg=(EditText)findViewById(R.id.editTextBloodgrp);
        final RadioButton vMale=(RadioButton)findViewById(R.id.radioButton);
        final RadioButton vFemale=(RadioButton)findViewById(R.id.radioButton2);
        DAOVolunteer daovol=new DAOVolunteer();
        register=(Button)findViewById(R.id.button3);

        fAuth=FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edage= vAge.getText().toString();
                int etinage = Integer.parseInt(edage);
                String email=vEmail.getText().toString().trim();
                String pw=vPw.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    vEmail.setError("Email is required!");
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
                Volunteer nvol=new Volunteer(vName.getText().toString(),vEmail.getText().toString(),vPw.getText().toString(),vMobile.getText().toString(),vBloodg.getText().toString(),etinage);
                daovol.add(nvol).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(),"User created",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Error! ",Toast.LENGTH_SHORT).show();
                    }
                });
                fAuth.createUserWithEmailAndPassword(email,pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent i=new Intent(Signup.this,Login.class);
                            startActivity(i);
                            finish();
                            //Toast.makeText(getApplicationContext(),"User created",Toast.LENGTH_SHORT).show();
                        }
//                        else{
//                            Toast.makeText(getApplicationContext(),"Error! "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
//                        }
                    }
                });
            }
        });
    }
}