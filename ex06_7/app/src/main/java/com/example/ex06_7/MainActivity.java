package com.example.ex06_7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TapHost tabHost = getTabHost();
        TapSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별");
        tabSpecSong.setContent(R.id.tabSong);
        tabHost.addTab(tabSpecSong);

        TabSpec tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("기수별");
            tabSpecArtist.setContent(R.id.tabArtist);

            TapSpec tabSpecAlbum = tabHost.newTapSpec("ALBUM").setIndicator("앨볌명");
            tapSpecAlbum.setContent(R.id.tapAlbum);
            tapHost.addTap(tabSpecAlbum);
            tabHost.setCurrrentTab(0);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
