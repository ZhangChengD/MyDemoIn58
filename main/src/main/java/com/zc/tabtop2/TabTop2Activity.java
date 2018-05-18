package com.zc.tabtop2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.zc.mydemoin58.R;


public class TabTop2Activity extends FragmentActivity {

    private View view;
    private ScrollView viewLay;
    private ViewPager viewPager;
    private float mHigh = 0;
    private float oldHigh = 0;
    private float nowHigh = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_top2);
        viewLay = (ScrollView) findViewById(R.id.nest_lv);
        initViewPager();
    }


    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.tabtop2_viewpager);
        TabTop2Adapter adapter = new TabTop2Adapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        view = findViewById(R.id.tab_top_header);
    }

    public void setMove(final float high) {

        if (oldHigh > 0 && high < 0) {
            oldHigh = high;
            return;
        }
        if (oldHigh < 0 && high > 0) {
            oldHigh = high;
            return;
        }


        if (mHigh == 0) {
            mHigh = view.getHeight();
        }
        if (nowHigh + high > mHigh) {
            nowHigh = mHigh;
        } else if (nowHigh + high < 0) {
            nowHigh = 0;
        } else {
            nowHigh = nowHigh + high;
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                layoutParams.setMargins(0, (int) -nowHigh, 0, 0);
                viewLay.setLayoutParams(layoutParams);
            }
        });

    }

}
