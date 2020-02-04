package com.example.project7_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout baseLayout;
    ImageView imageView;
    EditText gakdo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("각도바꾸기");
        baseLayout = (RelativeLayout) findViewById(R.id.baseLayout);
        imageView = (ImageView) findViewById(R.id.imageView);
        gakdo = (EditText) findViewById(R.id.gakdo);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0,1,0,"한국");
        menu.add(0,2,0,"스페인");
        menu.add(0,3,0,"이탈리아");
        menu.add(0,4,0,"각도변경");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                imageView.setBackgroundResource(R.drawable.korea);
                return true;
        }
        switch (item.getItemId()) {
            case 2:
                imageView.setBackgroundResource(R.drawable.spain);
                return true;
        }
        switch (item.getItemId()) {
            case 3:
                imageView.setBackgroundResource(R.drawable.italy);
                return true;
        }
        float sum = 0;
        switch (item.getItemId()) {
            case 4:
                float rot = Float.parseFloat(gakdo.getText().toString());
                sum += rot;
                imageView.setRotation(sum);
                return true;
        }
        return false;


    }
}
