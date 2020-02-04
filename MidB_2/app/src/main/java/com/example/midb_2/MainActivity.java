package com.example.midb_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String want ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int code = 0;
        int sleep = 0;
        int work = 0;
        int read = 0;

        final EditText edt0 =(EditText) findViewById(R.id.edt1);
        final EditText edt1 =(EditText) findViewById(R.id.edt2);
        final EditText edt2 =(EditText) findViewById(R.id.edt3);
        final EditText edt3 =(EditText) findViewById(R.id.edt4);
        final EditText edt4 =(EditText) findViewById(R.id.edt5);

        final CheckBox ch1=(CheckBox) findViewById(R.id.ch1);
        final CheckBox ch2=(CheckBox) findViewById(R.id.ch2);
        final CheckBox ch3=(CheckBox) findViewById(R.id.ch3);
        final CheckBox ch4=(CheckBox) findViewById(R.id.ch4);

        final TextView tv1 = (TextView) findViewById(R.id.tv8);
        final TextView tv2 = (TextView) findViewById(R.id.tv9);
        final TextView tv3 = (TextView) findViewById(R.id.tv10);

        Button btn1 = (Button)findViewById(R.id.resultBtn);

        final Spinner sp = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.like, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                want = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(),0);
                ArrayList<Integer> mID = new ArrayList<Integer>();


                int a0 =0;
                int a1 =0;
                int a2 =0;
                int a3 =0;
                int a4 =0;

                int sum =0;

                if(edt0.getText().toString().equals("")){
                    tv1.setText("1. 나는 ?시간 잠을 잡니다!");

                    new AlertDialog.Builder(MainActivity.this).setTitle("수면시간")
                            .setView(getLayoutInflater().inflate(R.layout.dialog, null))
                            .show();
                }else{
                    String r0 = edt0.getText().toString();
                    a0= Integer.parseInt(r0);
                    tv1.setText("1. 나는 "+a0+ "시간 잠을 잡니다");
                }

                if(ch1.isChecked() && !edt1.getText().toString().equals("")) {
                    String r1 = edt1.getText().toString();
                    a1 = Integer.parseInt(r1);
                    mID.add(R.drawable.programming);
                }else a1=0;

                if(ch2.isChecked() && !edt2.getText().toString().equals("")) {
                    String r2 = edt2.getText().toString();
                    a2 = Integer.parseInt(r2);
                    mID.add(R.drawable.book_reading);
                }else a2=0;

                if(ch3.isChecked()&& !edt3.getText().toString().equals("")) {
                    String r3 = edt3.getText().toString();
                    a3 = Integer.parseInt(r3);
                    mID.add(R.drawable.engligh_study);
                }else a3 =0;

                if(ch4.isChecked()&& !edt4.getText().toString().equals("")) {
                    String r5 = edt4.getText().toString();
                    a4 = Integer.parseInt(r5);
                    mID.add(R.drawable.work_out);
                }else a4 =0;

                sum=a1+a2+a3+a4;

                tv2.setText("2.나는 꿈을 위해 " +sum+"시간 투자합니다.");
                tv3.setText("3.나의 이상형은 " +want+" 입니다.");

                GridView gv1 = (GridView) findViewById(R.id.gv1);
                gv1.setAdapter(new ImageAdapter(MainActivity.this, mID));

            }
        });

        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ch1.isChecked()){
                    edt1.setFocusableInTouchMode(true);
                }else{
                    edt1.setFocusable(false);
                    edt1.setText("");
                }
            }
        });
        ch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ch2.isChecked()){
                    edt2.setFocusableInTouchMode(true);
                }else{
                    edt2.setFocusable(false);
                    edt2.setText("");
                }
            }
        });
        ch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ch3.isChecked()){
                    edt3.setFocusableInTouchMode(true);
                }else{
                    edt3.setFocusable(false);
                    edt3.setText("");
                }
            }
        });
        ch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ch4.isChecked()){
                    edt4.setFocusableInTouchMode(true);
                }else{
                    edt4.setFocusable(false);
                    edt4.setText("");
                }
            }
        });
    }
}
