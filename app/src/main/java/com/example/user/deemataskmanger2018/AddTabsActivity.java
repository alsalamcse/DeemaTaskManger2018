package com.example.user.deemataskmanger2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class AddTabsActivity extends AppCompatActivity {
    private EditText etTittle,etText,etDate;
    private SeekBar skbrImportant,skbrNecessary;
    private Button btnSave,btnDatePicker;




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

            }
        });
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


}
