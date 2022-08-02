package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import android.os.Bundle;

public class RegisterActivity extends AppCompatActivity {

    Calendar calendar;
    EditText textViewResult;
    Button buttonSetDate;
    int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonSetDate = (Button) findViewById(R.id.setDate);
        textViewResult = (EditText) findViewById(R.id.textDate);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);

        buttonSetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(1);
                Toast.makeText(getApplicationContext(), "Bạn hãy chọn 1 ngày!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id){
        if (id == 1){
            return  new DatePickerDialog(this, dataSetListener, year, month, day);
        }
        return null;
    }

    DatePickerDialog.OnDateSetListener dataSetListener = new DatePickerDialog.OnDateSetListener(){
       @Override
       public void onDateSet (DatePicker view, int year, int month, int day){
           showDate(year, month +1, day);
       }
    };

    private void showDate(int year, int month, int day) {
        textViewResult.setText(new StringBuilder().append(day > 9 ? day : "0" + day).append("/").append(month > 9 ? month : "0" + month).append("/").append(year));
    }


}




