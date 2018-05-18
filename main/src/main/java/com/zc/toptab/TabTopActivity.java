package com.zc.toptab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;

import com.zc.mydemoin58.R;


public class TabTopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_top);
        // 设置返回主页的按钮
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        // ViewPager
        ViewPager mPager = (ViewPager) findViewById(R.id.viewPager);
        TabTopAdapter mPagerAdapter = new TabTopAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        tabLayout.setupWithViewPager(mPager);
    }

}
