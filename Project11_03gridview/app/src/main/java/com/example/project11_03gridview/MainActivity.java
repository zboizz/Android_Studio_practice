package com.example.project11_03gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");


        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }

    public class MyGridAdapter extends BaseAdapter{
        Context context;
        public MyGridAdapter(Context c) {
            context = c;
        }

        //그리드뷰에 보여질 이미지의 개수를 반환하도록 수정
        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //영화포스터를 각 그리드뷰의 칸마다 이미지뷰를 생성해서 보여주게 함
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(100,150));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5,5,5,5);

            imageview.setImageResource(posterID[position]);
            final int pos = position;
            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(MainActivity.this,
                            R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle("큰포스터");
                    dlg.setIcon(R.drawable.ic_launcher);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });
            return imageview;
        }
    }

    Integer[] posterID = {
            R.drawable.mov05, R.drawable.mov10, R.drawable.mov12, R.drawable.mov13,
            R.drawable.mov18, R.drawable.mov06, R.drawable.mov11, R.drawable.mov25,
            R.drawable.mov51, R.drawable.mov55,
            R.drawable.mov05, R.drawable.mov10, R.drawable.mov12, R.drawable.mov13,
            R.drawable.mov18, R.drawable.mov06, R.drawable.mov11, R.drawable.mov25,
            R.drawable.mov51, R.drawable.mov55,
            R.drawable.mov05, R.drawable.mov10, R.drawable.mov12, R.drawable.mov13,
            R.drawable.mov18, R.drawable.mov06, R.drawable.mov11, R.drawable.mov25,
            R.drawable.mov51, R.drawable.mov55,
            R.drawable.mov05, R.drawable.mov10, R.drawable.mov12, R.drawable.mov13,
            R.drawable.mov18, R.drawable.mov06, R.drawable.mov11, R.drawable.mov25,
            R.drawable.mov51, R.drawable.mov55
    };
}
