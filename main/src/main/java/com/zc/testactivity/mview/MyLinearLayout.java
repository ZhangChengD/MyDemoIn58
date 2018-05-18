package com.zc.testactivity.mview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by 张程 on 18/3/15.
 */

public class MyLinearLayout extends LinearLayout {

    private static String TAG = "MyLinearLayout";
    public int id = 0;

    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if (id == 2) {
//            Log.e(TAG, id + " -- dispatchTouchEvent end");
//            return true;
//        }
        Log.e(TAG, id + " -- dispatchTouchEvent" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        if (id == 2) {
//            Log.e(TAG, id + " -- onInterceptTouchEvent end");
//            return false;
//        }
        Log.e(TAG, id + " -- onInterceptTouchEvent" + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }
}
