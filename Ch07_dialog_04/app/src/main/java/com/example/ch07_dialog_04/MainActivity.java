package com.example.ch07_dialog_04;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtMail;
    Button button1;
    EditText dlgEdtName, dlgEdtMail;
    TextView toastText;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보입력");

        edtName = (EditText) findViewById(R.id.edtName);
        edtMail = (EditText) findViewById(R.id.edtMail);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View) View.inflate(MainActivity.this,R.layout.dialog1,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 수정");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dialogView);

                dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdtName);
                dlgEdtMail = (EditText) dialogView.findViewById(R.id.dlgEdtMail);

                dlgEdtName.setText(edtName.getText().toString());
                dlgEdtMail.setText(edtMail.getText().toString());

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dlgEdtName=(EditText) dialogView.findViewById(R.id.dlgEdtName);
                        dlgEdtMail=(EditText) dialogView.findViewById(R.id.dlgEdtMail);

                        edtName.setText(dlgEdtName.getText().toString());
                        edtMail.setText(dlgEdtMail.getText().toString());
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = new Toast(MainActivity.this);
                        toastView = (View) View.inflate(MainActivity.this,R.layout.toast1, null);
                        toastText = (TextView) toastView.findViewById(R.id.toastText1);
                        toastText.setText("취소했습니다");
                        toast.setView(toastView);
                        toast.show();
                    }
                });
                dlg.show();
            }
        });
    }
}
