package com.roshh.tcenssapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText vEmail, vPw;
    Button btn;
    FirebaseAuth fAuth;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        tv=(TextView)findViewById(R.id.textView);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this,Signup.class);
                startActivity(i);
//                finish();
            }
        });
        vEmail=(EditText)findViewById(R.id.editTextTextPersonName);
        vPw=(EditText)findViewById(R.id.editTextTextPassword);
        btn=(Button)findViewById(R.id.button3);
        fAuth=FirebaseAuth.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

                fAuth.signInWithEmailAndPassword(email,pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent=new Intent(Login.this, BottomNav.class);
                            startActivity(intent);
                            finish();
                            Toast.makeText(getApplicationContext(),"Logged in successfully",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Error! "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

}