package com.example.project7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button button1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기");
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0, 1, 0, "배경색(빨강)");
        menu.add(0, 2, 0, "배경색(파랑)");
        menu.add(0, 3, 0, "배경색(초록)");

        SubMenu sMenu = menu.addSubMenu("버튼 변경>>");
        sMenu.add(0,4,0,"버튼 45도 회전");
        sMenu.add(0,5,0,"버튼 2배 확대");

        /*MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);*/

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
        }

        switch (item.getItemId())
        {
            case 2:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
        }

        switch (item.getItemId())
        {
            case 3:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;

            case 4:
                button1.setRotation(45);
                return true;
            case 5:
                button1.setScaleX(2);
                return true;
        }
        return false;
    }
}
