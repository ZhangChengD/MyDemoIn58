package com.zc.slidingmenu;

import android.app.Activity;
import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.zc.mydemoin58.R;

public class SlidingMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_menu);
        // configure the SlidingMenu
        SlidingMenu menu = new SlidingMenu(this);
        //是否有左侧右侧的View的设置
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.dimen_15dp);
        //菜单栏靠content测是否有阴影图案
//        menu.setShadowDrawable(R.drawable.icon_ball_1);

        // 设置活动后content剩余的宽度
        menu.setBehindOffsetRes(R.dimen.dimen_60dp);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        /**
         * SLIDING_WINDOW will include the Title/ActionBar in the content
         * section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        // 为侧滑菜单设置布局
        menu.setMenu(R.layout.activity_demo_image_leak);
        // 为右侧sencendView设置布局
        menu.setSecondaryMenu(R.layout.activity_demo_image_leak);
        //设置中间的content 的布局
        menu.setContent(R.layout.activity_sliding_menu);
    }

}
