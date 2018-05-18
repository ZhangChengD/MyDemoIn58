package com.zc.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.zc.mydemoin58.R;

import java.util.ArrayList;
import java.util.List;

public class MyViewPagerActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private List<Fragment> mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_pager);
        initVP();
    }

    private void initVP() {
        mViewPager = (ViewPager) findViewById(R.id.my_viewpager);
        mViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
    }

}
