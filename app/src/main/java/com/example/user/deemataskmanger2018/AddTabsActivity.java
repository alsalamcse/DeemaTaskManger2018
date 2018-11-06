package com.example.user.deemataskmanger2018;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;

import java.util.Calendar;

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
        boolean isok=true;
        String Tittle=etTittle.getText().toString();
        String Text=etText.getText().toString();
        String  Date=etDate.getText().toString();
       int important=skbrImportant.getProgress();
       int Necessary=skbrNecessary.getProgress();
       if(Tittle.length()<4)
       {
        etTittle.setError("tittle have to be more than 4 char");
        isok=false;

       }
        if(Text.length()<4)
        {
            etText.setError("Text have to be more than 4 char");
            isok=false;

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
