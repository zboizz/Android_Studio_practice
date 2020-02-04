package com.example.mida_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String gender ="여자";
    String blood = "A";

    double height = 0;
    double weight = 0;
    double bmi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edt1 =(EditText) findViewById(R.id.heightEdt);
        final EditText edt2 =(EditText) findViewById(R.id.weightEdt);

        final RadioGroup rg = (RadioGroup) findViewById(R.id.genderRG);
        final RadioButton rb1 = (RadioButton) findViewById(R.id.femaleRB);
        final RadioButton rb2 = (RadioButton) findViewById(R.id.maleRB);

        final Spinner sp = (Spinner) findViewById(R.id.SpinnerBl);

        final CheckBox cb1 = (CheckBox) findViewById(R.id.cb1);
        final CheckBox cb2 = (CheckBox) findViewById(R.id.cb2);
        final CheckBox cb3 = (CheckBox) findViewById(R.id.cb3);

        final TextView tv1=(TextView) findViewById(R.id.tv1);
        final TextView tv2=(TextView) findViewById(R.id.tv2);

        Button btn1 = (Button) findViewById(R.id.checkingBtn);

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton) v;
                gender = rb.getText().toString();
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton) v;
                gender = rb.getText().toString();
            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.blood_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                blood = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //하단의 키보드가 없어지게 하는 코드
                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(), 0);

                ArrayList<Integer> mThumblds = new ArrayList<Integer>();

                if(edt1.getText().toString().equals("")|| edt2.getText().toString().equals("")){
                    tv2.setText("2. 신체질량지수는 ??입니다!!");

                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("키와 체중")
                            .setView(getLayoutInflater().inflate(R.layout.custom_dialog, null))
                            .show();
                }else{
                    String str1 = edt1.getText().toString();
                    String str2 = edt2.getText().toString();

                    height = Double.parseDouble(str1);
                    weight = Double.parseDouble(str2);

                    bmi = weight / ((height/100) *(height/100));
                    tv2.setText("2.신체질량지수는" + Math.round(bmi*10)/10F +"입니다");
                }

                if(blood.equals("") || gender.equals("")){
                    tv1.setText("1. ?형 ??입니다!");
                    return;
                }else{
                    tv1.setText("1. "+blood+"형 "+gender+"입니다!");
                }
                if(cb1.isChecked()){
                    mThumblds.add(R.drawable.drinking);
                }
                if(cb2.isChecked()){
                    mThumblds.add(R.drawable.ciga);
                }
                if(!cb3.isChecked()){
                    mThumblds.add(R.drawable.running);
                }

                Gallery gal = (Gallery) findViewById(R.id.gal);
                if(cb1.isChecked() || cb2.isChecked() || !cb3.isChecked()){
                    gal.setAdapter(new ImageAdapter(MainActivity.this, mThumblds));
                }
                else {
                    //갤러리 레이아웃 초기화
                    gal.removeAllViewsInLayout();
                }

            }
        });
    }
}
