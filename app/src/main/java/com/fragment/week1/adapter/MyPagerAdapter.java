package com.fragment.week1.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fragment.week1.fragment.OneFragment;
import com.fragment.week1.fragment.SecondFragment;

/**
 * Created by r on 2017/6/10.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    String[] title = new String[]{"热点","娱乐","体育","财经","军事"};
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position%2==0){
            OneFragment fragment1 = new OneFragment();
            return fragment1;
        }else {
            SecondFragment fragment2 = new SecondFragment();
            return fragment2;
        }

    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
