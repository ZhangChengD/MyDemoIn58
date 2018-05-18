package com.zc.toptab;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import com.zc.util.ToastUtills;

/**
 * Created by 张程 on 17/4/21.
 */

public class MyRecyclerView extends RecyclerView {
    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    float mX = 0;
    float my = 0;
    float mX2 = 0;
    float my2 = 0;

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        Log.e("zc", "onTouchEvent rv");
        return super.onTouchEvent(e);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {

        Log.e("zc", "onInterceptTouchEvent rv");
        return super.onInterceptTouchEvent(e);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent e) {
        Log.e("zc", "dispatchTouchEvent rv");
        return super.dispatchTouchEvent(e);
    }
}
