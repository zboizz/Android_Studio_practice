package com.example.project12_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    myDBHelper myHelper;
    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnSelect, btnUpgrade, btnDelete;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가수 그룹 관리 DB");

        edtName = (EditText) findViewById(R.id.edtName);
        edtNumber = (EditText) findViewById(R.id.edtNumber);

        edtNameResult= (EditText) findViewById(R.id.edtNameResult);
        edtNumberResult=(EditText) findViewById(R.id.edtNumberResult);

        btnInit =(Button) findViewById(R.id.btnInit);
        btnInsert =(Button) findViewById(R.id.btnInsert);
        btnSelect =(Button) findViewById(R.id.btnSelect);
        btnUpgrade =(Button) findViewById(R.id.btnUpgrade);
        btnDelete =(Button) findViewById(R.id.btnDelete);

        myHelper = new myDBHelper(this);
        btnInit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB, 1, 2);
                sqlDB.close();
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ('"
            + edtName.getText().toString()+"', "
                        + edtNumber.getText().toString() + ");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "입력됨",Toast.LENGTH_SHORT).show();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(),0);
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;",null);

                String strNames = "그룹 이름" + "\r\n" +"-------" + "\r\n";
                String strNumbers = "인원" + "\r\n" + "--------" + "\r\n";

                while (cursor.moveToNext()){
                    strNames += cursor.getString(0) + "\r\n";
                    strNumbers += cursor.getString(1) + "\r\n";
                }
                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNumbers);

                cursor.close();
                sqlDB.close();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getReadableDatabase();
                sqlDB.execSQL("DELETE from groupTBL where gName ='" + edtName.getText().toString() +"';");
                sqlDB.close();
            }
        });
        btnUpgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getReadableDatabase();
                sqlDB.execSQL("UPDATE groupTBL set gName = ('"
                        + edtName.getText().toString()+"', "
                        + edtNumber.getText().toString() + ");");
                sqlDB.close();
            }
        });

    }
        public class myDBHelper extends SQLiteOpenHelper{
            public myDBHelper(Context context){
                super(context, "groupDB", null, 1);
            }

            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL("CREATE TABLE groupTBL (gName CHAR(20) PRIMARY KEY, " +
                        "gNumber INTEGER);");
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL("DROP TABLE IF EXISTS groupTBL");
                onCreate(db);
            }
        }
    }

