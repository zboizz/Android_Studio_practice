package com.example.mida_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edt1 = (EditText) findViewById(R.id.randomEdt1);
        final EditText edt2 = (EditText) findViewById(R.id.randomEdt2);
        final EditText edt3 = (EditText) findViewById(R.id.answerEdt);

        final ListView list1 = (ListView) findViewById(R.id.list1);

        Button btnRandom = (Button) findViewById(R.id.btnRandom);
        Button btnchecking = (Button) findViewById(R.id.btnChecking);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rand1 = new Random().nextInt(8)+2;
                int rand2 = new Random().nextInt(8)+2;

                edt1.setText(String.valueOf(rand1));
                edt2.setText(String.valueOf(rand2));
            }
        });

        btnchecking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(),0);

                if(edt1.getText().toString().equals("")||edt2.getText().toString().equals("")||edt3.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "값을 넣어주세요!", Toast.LENGTH_SHORT).show();
                }else{
                String str1 = edt1.getText().toString();
                String str2 = edt2.getText().toString();
                String str3 = edt3.getText().toString();

                int a1 = Integer.parseInt(str1);
                int a2 = Integer.parseInt(str2);
                int a3 = Integer.parseInt(str3);

                int a4 = a1 * a2;

                if(a3 == a4){
                    Toast.makeText(MainActivity.this, "정답입니다", Toast.LENGTH_SHORT).show();

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1, new String[0]);
                    list1.setAdapter(adapter);
                }else {
                    Toast.makeText(MainActivity.this, "오답입니다.", Toast.LENGTH_SHORT).show();

                    String[] values = new String[9];
                    for (int i = 0; i < 9; i++) {
                        values[i] = String.valueOf(a1) + "X" + (i + 1) + "=" + (a1 + (i + 1));
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1, values);
                    list1.setAdapter(adapter);
                }
                }

            }
        });

    }
}
