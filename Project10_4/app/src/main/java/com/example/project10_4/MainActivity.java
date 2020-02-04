package com.example.project10_4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        final EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
        final EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);
        final RadioGroup rdGroup = (RadioGroup)findViewById(R.id.rdGroup);

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                Log.i("액티비티1", "onClikc 눌러졌음!");

                switch(rdGroup.getCheckedRadioButtonId()) {
                    case R.id.plusRB:
                        intent.putExtra("Calc","+");
                        break;
                    case R.id.minusRB:
                        intent.putExtra("Calc", "-");
                        break;
                    case R.id.multiRB:
                        intent.putExtra("Calc", "*");
                        break;
                    case R.id.divRB:
                        intent.putExtra("Calc", "/");
                        break;
                    default:
                        break;
                }

                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(),"합계 : " + hap, Toast.LENGTH_SHORT).show();
        }
    }
}
