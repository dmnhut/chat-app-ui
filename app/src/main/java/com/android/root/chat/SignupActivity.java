package com.android.root.chat;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;

public class SignupActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private EditText edtDate;
    private ImageButton imgDate;
    private DatePickerDialog datePickerDialog;
    private RadioGroup radioSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        final DatePickerDialog datePickerDialog = new DatePickerDialog(this, SignupActivity.this, 1996, 3, 3);
        edtDate = (EditText) findViewById(R.id.edtDate);
        imgDate = (ImageButton) findViewById(R.id.imgDate);
        radioSex = (RadioGroup) findViewById(R.id.radioSex);
        imgDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        edtDate.setText(dayOfMonth + "/" + ((int) month + 1) + "/" + year);
    }
}
