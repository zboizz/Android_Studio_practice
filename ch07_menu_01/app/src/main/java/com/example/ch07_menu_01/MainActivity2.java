package com.example.ch07_menu_01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    EditText edtAngle;
    ImageView imageView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("제주도 풍경");

        edtAngle = (EditText) findViewById(R.id.edtAngle);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        super.onCreateOptionsMenu(menu);
//        MenuInflater mInflater = getMenuInflater();
//        mInflater.inflate(R.menu.menu2, menu);
//        return true;
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu2, menu);

        return super.onCreateOptionsMenu(menu);
    }


//
    float sum = 0;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRotate:
                float rot = Float.parseFloat(edtAngle.getText()
                        .toString());
                sum += rot;
                
                imageView1.setRotation(sum);

                return true;
            case R.id.item1:
                imageView1.setImageResource(R.drawable.jeju2);
                item.setChecked(true);
                return true;
            case R.id.item2:
                imageView1.setImageResource(R.drawable.jeju4);
                item.setChecked(true);
                return true;
            case R.id.item3:
                imageView1.setImageResource(R.drawable.jeju5);
                item.setChecked(true);
                return true;
        }
        return false;
    }
}
