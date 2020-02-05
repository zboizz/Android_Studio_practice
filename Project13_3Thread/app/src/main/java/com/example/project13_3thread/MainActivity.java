package com.example.project13_3thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb1, pb2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = (ProgressBar) findViewById(R.id.pb1);
        pb2 = (ProgressBar) findViewById(R.id.pb2);
        btn = (Button) findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0; i<100; i++){
                    pb1.setProgress(pb1.getProgress()+2);
                    pb2.setProgress(pb1.getProgress()+1);
                    SystemClock.sleep(100);
                }
            }
        });
    new Thread(){
        public void run() {
            for(int i =pb1.getProgress(); i<1000; i=i+2){
                pb1.setProgress(pb1.getProgress()+2);
                SystemClock.sleep(100);
            }
        }
    }.start();

    new Thread() {
        public void run() {
            for (int i=pb2.getProgress(); i<1000; i++){
                pb2.setProgress(pb2.getProgress()+1);
                SystemClock.sleep(100);
            }
        }
    }.start();

    }
}
