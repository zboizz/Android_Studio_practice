package com.example.ch06_actionbar;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

//MainActibity 는 다중상속받고 있는 상태
@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
//declare abstract or implement abstract method 'onTabSelected'

    //1. 멤버변수
    ActionBar.Tab tabSong, tabArtist, tabAlbum;
    //프래그먼트가 세개가 있고 이것들이 차례대로 들어갈것이다.
    MyFragment []myFrags3=new MyFragment[3];

    //2. (멤버)메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. 액션바를 구현
        //ActionBar bar getActionBar(); 교재에는 이와 같이 적혀있다.
        //그러나 이는 버전이 맞지않다.
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabSong = bar.newTab();
        tabSong.setText("음악별");
        tabSong.setTabListener(this);
        bar.addTab(tabSong);

        tabArtist = bar.newTab();
        tabArtist.setText("가수별");
        tabArtist.setTabListener(this);
        bar.addTab(tabArtist);

        tabAlbum = bar.newTab();
        tabAlbum.setText("앨범별");
        tabAlbum.setTabListener(this);
        bar.addTab(tabAlbum);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab/*액션바 탑 메뉴*/, FragmentTransaction ft) {
        //3. 이벤트 처리내용(1. 액션바에 2. 프레그먼트(연결한다.) 동작 이벤트)
        //프레그먼트 실행

        MyFragment myFrag1 = null;

        if(myFrags3[tab.getPosition()]==null) //탭이 안눌러졌을 때, 초기에(처음에)
        {
            myFrag1 = new MyFragment();
            Bundle data = new Bundle();
            data.putString("tabName",tab.getText().toString()); //프래그먼트 -> 액션바 탭 메뉴로 보냄
            //tabName값을 가져와 toString 해준다.

            myFrag1.setArguments(data);

            myFrags3[tab.getPosition()] = myFrag1;
        }
        else //다른 것들이 눌러졌을때
        {
            myFrag1 = myFrags3[tab.getPosition()];
        }
        ft.replace(android.R.id.content, myFrag1);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }
    //3. 프레그먼트 구현
   /* public static class MyFragment extends Fragment
    {
        String tabName;
        //프래그먼트가 생길때 기본적으로 생기는 것
        //Generate-override Method-onCreate
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            //tabName값을 가져와 판단을 해서 화면을 바꾸어줌
            //판단의 기준값은 tabName
            tabName = data.getString("tabName");
        }*/

        //프래그먼트의 뷰를 설정할때 필요한 것
           /* @Nullable
            @Override
            public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                //View에 그릴 내용을 구현
                //1. activity_Layout2.xml에서 들고 오기
                //->inflate로 xml을 가져온다.

                //2. java에서 직접 구현하기 -> 이 방식을 사용할 것

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);

                LinearLayout baseLayout = new LinearLayout(getActivity());
                baseLayout.setOrientation(LinearLayout.VERTICAL);
                baseLayout.setLayoutParams(params);

                if(tabName =="음악별")
                    baseLayout.setBackgroundColor(Color.RED);
                    //구현을 해준다. 지금은 바탕색만 설정
                if(tabName =="가수별")
                    baseLayout.setBackgroundColor(Color.GREEN);

                if(tabName =="앨범별")
                    baseLayout.setBackgroundColor(Color.BLUE);

                return baseLayout;
            }
        }*/
}
