package com.example.user.deemataskmanger2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SingUpActivity extends AppCompatActivity {
    private EditText edFirstName,edLastName,edPhone,edEmail2,edPassWord2;
    private Button btnSave;

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


    }
}
