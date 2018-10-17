package com.example.user.deemataskmanger2018;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SingUpActivity extends AppCompatActivity {
    private EditText edFirstName,edLastName,edPhone,edEmail2,edPassWord2;
    private Button btnSave;
    //1.add auth to project
    //2.
    FirebaseAuth auth;//to establish sign in sign up
    FirebaseUser user;//user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        edFirstName=(EditText)findViewById(R.id .edFirstName) ;
        edLastName=(EditText)findViewById(R.id .edLastName) ;
        edPhone=(EditText) findViewById(R.id .edPhone) ;
        edEmail2=(EditText) findViewById(R.id .edEmail2) ;
        edPassWord2=(EditText)findViewById(R.id .edPassWord2) ;
        btnSave=(Button)findViewById(R.id .btnSave) ;
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // كود الانتقال إلى الشاشة الأخرى
                Intent i=new Intent(SingUpActivity.this, loginActivity.class);
                startActivity(i);
            }
        });
        //3.
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();//

    }
    private void creatAcount(String email,String passw){
        auth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener(SingUpActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(SingUpActivity.this,"Authentication successful",Toast.LENGTH_SHORT).show();
                   //updateUserProfile(task.getResult().getUser();
                    finish();
                }
                else {
                    Toast.makeText(SingUpActivity.this, "Authentication failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }}});


            }

    }

