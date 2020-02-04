package com.example.midb_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edt1 = (EditText) findViewById(R.id.numEdt1);
        final EditText edt2 = (EditText) findViewById(R.id.numEdt2);
        final EditText edt3 = (EditText) findViewById(R.id.numEdt3);

        final TextView tv1 = (TextView) findViewById(R.id.tv1);

        RadioGroup.OnCheckedChangeListener rLis = new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                tv1.setText(rb.getText());
            }
        };

        RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(rLis);

        final RadioButton rb1 = (RadioButton) findViewById(R.id.rb1);
        final RadioButton rb2 = (RadioButton) findViewById(R.id.rb2);
        final RadioButton rb3 = (RadioButton) findViewById(R.id.rb3);
        final RadioButton rb4 = (RadioButton) findViewById(R.id.rb4);

        Button calBtn = (Button) findViewById(R.id.calBtn);



        calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = edt1.getText().toString();
                String str2 = edt2.getText().toString();

                double a1 =Double.parseDouble(str1);
                double a2 =Double.parseDouble(str2);
                double a3 =0; //결과값의 초기값은 0

                String op = tv1.getText().toString();

                if(op.equals("+"))
                    a3 = a1+a2;
                else if(op.equals("-"))
                    a3 = a1-a2;
                else if(op.equals("*"))
                    a3 = a1*a2;
                else if(op.equals("/"))
                    a3 = a1/a2;

                edt3.setText(String.valueOf(a3));

            }
        });
    }
}
