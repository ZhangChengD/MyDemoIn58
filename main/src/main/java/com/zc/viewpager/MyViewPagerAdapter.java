package com.zc.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张程 on 17/7/28.
 */

public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    public List<String> lists = new ArrayList<>();
    private static int MAX = 5;

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initData();
    }

    public void initData() {
        for (int i = 0; i < MAX; i++) {
            lists.add("index=" + i);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return new TestFragment();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TestFragment fragment = (TestFragment) super.instantiateItem(container,
                position);
//        if (lists != null && position < lists.size()){
//            fragment.bindView(lists.get(position));
//        }
//        Log.e("zc","instantiateItem = "+ fragment.hashCode());
        return fragment;
    }

    @Override
    public int getCount() {
        return MAX;
    }
}
