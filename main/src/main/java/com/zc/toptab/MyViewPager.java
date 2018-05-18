package com.zc.toptab;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.zc.util.ToastUtills;

/**
 * Created by 张程 on 17/4/18.
 */

public class MyViewPager extends ViewPager {

    private float lastX;
    private float lastY;

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.e("zc","onTouchEvent vp");
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        Log.e("zc","onInterceptTouchEvent vp");

        return super.onInterceptTouchEvent(ev);
    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.e("zc","dispatchTouchEvent vp");
        return super.dispatchTouchEvent(ev);
    }
}
