package com.example.ch07_dialog_02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {

            boolean[] checkArray = new boolean[] {true, false, false};
            String[] versionArray = new String[]{"롤리팝", "마시멜로", "누가"};

            @Override
            public void onClick(View v) {
                //다중체크를 할때, 하나의 값뿐만 아니라 체크한 값들 모두 뜨기 위하여
                //final을 빼야한다. 대신 versionArray는 바뀔 일이 없으므로 final 유지

                /*final boolean[] checkArray = new boolean[] {true, false, false};
                final String[] versionArray = new String[]{"롤리팝", "마시멜로", "누가"};*/


                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("좋아하는 버전은?");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setMultiChoiceItems(versionArray, checkArray,
                        new DialogInterface.OnMultiChoiceClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        //button1.setText(versionArray[which]);

                        //1. 체크 상태를 저장(배열변수에)
                        //ischecked가 true라면 true로 바꾸어 준다.
                        //아니라면 false로 상태값을 변경한다.
                        if(isChecked)
                            checkArray[which] = true;
                        else
                            checkArray[which] = false;

                        //2. 출력할 문자열 만들기(체크상태(저장배열기준)에 따라서)
                        String str = ""; //str값을 초기화 시켜준다.
                        for (int i =0; i < checkArray.length; ++i)
                           if(checkArray[i] == true)
                               if(!str.equals(""))
                            str = str +","+ versionArray[i]; //출력 문자열 만들기
                               else
                                   str += versionArray[i]; //출력 문자열 만들기
                        //모든 str값을 누적시켜서는 안된다.
                        //checkArray[i]값이 true인것만 누적시킨다.

                        //3. 만든 문자열을 출력(단, 체크가 모두 해지일때 예외처리)
                        if(str.equals(""))
                            button1.setText("대화상자");
                        else
                            button1.setText(str);
                    }
                });
                dlg.setPositiveButton("닫기", null);
                dlg.show();
            }
        });
    }
}