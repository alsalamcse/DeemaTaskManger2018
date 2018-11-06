package com.example.user.deemataskmanger2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class loginActivity extends AppCompatActivity {
    private EditText edEmail,edPassWord;
    private Button btnLogIN,btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edEmail=(EditText)findViewById(R.id .edEmail) ;
        edPassWord=(EditText)findViewById(R.id .edPassWord) ;
        btnLogIN=(Button)findViewById(R.id .btnLogIn) ;
        btnSignUp=(Button) findViewById(R.id .btnSignUp) ;



        btnLogIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // كود الانتقال إلى الشاشة الأخرى
                Intent i=new Intent(loginActivity.this, SingUpActivity.class);
                startActivity(i);
            }
        });



    }

    private void dataHandler() {
        boolean isk=true;// if all the fields filled well
        String email=edEmail.getText().toString();
        String passWord=edPassWord.getText().toString();
        boolean isok=true;
        if (email.length()<4||
                email.indexOf('@') <0 || email.indexOf('.')<0)
        {
            edEmail.setError("Wrong Email");
            isok = false;

        }
        if (passWord.length()<8)
        {
            edPassWord.setError("Have to be at least 8 char ");
            isok = false;

        }
        private void LogI
            auth​.signInWithEmailAndPassword(email,passw).addOnCompleteListener(LogInActivity.this​, new
                    OnCompleteListener<AuthResult>() {
                        @Override
                        public void ​onComplete(@NonNull Task<AuthResult> task) {
                            if​(task.isSuccessful())
                            {
                                Toast.makeText(LogInActivity.this​, "signIn Successful."​, Toast.LENGTH_SHORT​).show();
    }
}
