package com.example.ch06_actionbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//2.프레그먼트 구현
public class MyFragment extends Fragment
{
    String tabName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle data = getArguments();
        tabName = data.getString("tabName");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //View에 그릴 내용 구현
        //1.activity_layout2.xml 에서 들고 오기 -> inflate 로 xml을 가져온다.
        //2.java에서 직접 구현하기 -> 이방식 씀

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(getActivity());
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setLayoutParams(params);

        if(tabName == "음악별") {
            baseLayout.setBackgroundColor(Color.DKGRAY); // 구현을 해준다.
        }
        if(tabName == "가수별") {
            baseLayout.setBackgroundColor(Color.GRAY); // 구현을 해준다.
        }
        if(tabName == "앨범별") {
            baseLayout.setBackgroundColor(Color.BLACK); // 구현을 해준다.
        }

        return baseLayout;
    }
}
