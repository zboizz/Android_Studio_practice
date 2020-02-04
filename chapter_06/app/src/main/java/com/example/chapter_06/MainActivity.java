package com.example.chapter_06;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.ex06_1);
       /* String[] items = {"CSI-뉴욕", "CSI-라스베가스","CSI-마이애미", "Friends", "Lost", "Fringe" };
        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);

        MultiAutoCompleteTextView multi = (MultiAutoCompleteTextView)
                findViewById(R.id.multiAutoCompleteTextView1);
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multi.setTokenizer(token);
        multi.setAdapter(adapter);*/
        setContentView(R.layout.ex06_2);
        setContentView(R.layout.ex06_3);
        setContentView(R.layout.ex06_4);
        setContentView(R.layout.ex06_5);
        setTitle("시간예약");
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        chrono = (Chronometer) findViewById(R.id.chronometer1);
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        tPicker = (TimePicker) findViewById(R.id.timePicker1);
        calView = (CalendarView) findViewById(R.id.calendarView1);

        tvYear=(TextView) findViewById(R.id.tvYear);
        tvMonth=(TextView) findViewById(R.id.tvMonth);
        tvDay=(TextView) findViewById(R.id.tvDay);
        tvHour=(TextView) findViewById(R.id.tvHour);
        tvMinute=(TextView) findViewById(R.id.tvMinute);

        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                tPicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
            }
        });
        java.util.Calendar curDate = java.util.Calendar.getInstance();
        curDate.setTimeInMillis(calView.getDate());
        tvYear.setText(Integer.toString(curDate.get(Calendar.YEAR)));
        tvMonth.setText(Integer.toString(1+curDate.get(Calendar.MONTH)));
        tvDay.setText(Integer.toString(curDate.get(Calendar.DATE)));

        tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
        tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));

    }

}
