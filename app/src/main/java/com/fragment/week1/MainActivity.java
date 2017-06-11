package com.fragment.week1;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fragment.week1.adapter.MyPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout mtablayout;
    private ViewPager mvp;
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtablayout = (TabLayout) findViewById(R.id.mtablayout);
        mvp = (ViewPager) findViewById(R.id.mvp);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        mvp.setAdapter(adapter);
        mtablayout.setupWithViewPager(mvp);
    }
}
