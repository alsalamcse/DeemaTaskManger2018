package com.example.user.deemataskmanger2018;

import android.app.DatePickerDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class AddTabsActivity extends AppCompatActivity {
    private EditText etTittle,etText,etDate;
    private SeekBar skbrImportant,skbrNecessary;
    private Button btnSave,btnDatePicker;
    private int mYear,mMonth,mDay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tabs2);
        etTittle=findViewById(R.id.etTittle);
        etText=findViewById(R.id.etTask);
        etDate=findViewById(R.id.etDate);
        skbrImportant=findViewById(R.id.skbrImportant);
        skbrNecessary=findViewById(R.id.skbrNecessary);
        btnDatePicker=findViewById(R.id.btnDataPicker);
        btnSave=findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();

            }
        });

    }


    private void dataHandler() {
        boolean isok = true;
        String Tittle = etTittle.getText().toString();
        String Text = etText.getText().toString();
        String Date = etDate.getText().toString();
        int important = skbrImportant.getProgress();
        int Necessary = skbrNecessary.getProgress();
        if (Tittle.length() ==0) {
            etTittle.setError("tittle can not be empty");
            isok = false;

        }
        if (Text.length() == 0) {
            etText.setError("Text can not be empty");
            isok = false;

        }
        if (isok) {
            MyTask task = new MyTask();
            task.setCreatedAt(new Date());
            task.setDueDate(new Date(Date));
            task.setText(Text);
            task.setTittle(Tittle);
            task.setImportant(important);
            task.setNecessary(Necessary);
            //GET USER EMAIL TO SET IS AS THE OWNER OF THIS TASK
            FirebaseAuth auth = FirebaseAuth.getInstance();
            task.setOwner(auth.getCurrentUser().getEmail());
            //TO GET THE DATABASE ROOT REFERENCE
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            //TO GET UID(UNIVERSAL ID )
            String Key = reference.child("MyTask").push().getKey();
            task.setKey(Key);
            reference.child("MyTask").child(Key).setValue(task).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(AddTabsActivity.this, "Add Successfu", Toast.LENGTH_LONG).show();
                    }

                }
            });
        }




    }

    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            etDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }


}
