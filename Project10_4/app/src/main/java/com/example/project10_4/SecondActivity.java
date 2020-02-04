package com.example.project10_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");

        Intent inIntent = getIntent();

        String calc = (inIntent.getStringExtra("Calc"));

        int calValue = 0;
        if(calc.equals("+")){
            calValue = inIntent.getIntExtra("Num1",0)
                    +inIntent.getIntExtra("Num2",0);
        }else if(calc.equals("-")){
            calValue = inIntent.getIntExtra("Num1",0)
                    -inIntent.getIntExtra("Num2",0);
        }else if(calc.equals("*")) {
            calValue = inIntent.getIntExtra("Num1", 0)
                    *inIntent.getIntExtra("Num2", 0);
        }else if(calc.equals("/")) {
            calValue = inIntent.getIntExtra("Num1", 0)
                    / inIntent.getIntExtra("Num2", 0);
        }
        final int retValue = calValue;

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent outIntent = new Intent(getApplicationContext(),
                        MainActivity.class);
                outIntent.putExtra("Hap", retValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
