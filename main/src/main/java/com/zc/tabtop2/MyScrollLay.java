package com.zc.tabtop2;

import android.content.Context;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by 张程 on 17/4/24.
 */

public class MyScrollLay extends ScrollView implements NestedScrollingParent {

    private NestedScrollingParentHelper mParentHelper = new NestedScrollingParentHelper(this);

    private String TAG = "zc";

    public MyScrollLay(Context context) {
        super(context);
    }

    public MyScrollLay(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollLay(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {

        Log.d(TAG, "child==target:" + (child == target));

        Log.d(TAG, "----父布局onStartNestedScroll----------------");

        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {

        Log.d(TAG, "----父布局onNestedScrollAccepted---------------");

        mParentHelper.onNestedScrollAccepted(child, target, nestedScrollAxes);
    }

    @Override
    public void onStopNestedScroll(View target) {
        Log.d(TAG, "----父布局onStopNestedScroll----------------");
        mParentHelper.onStopNestedScroll(target);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed,
                               int dxUnconsumed, int dyUnconsumed) {
        Log.d(TAG, "----父布局onNestedScroll----------------");
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        scrollBy(0, -dy);

        consumed[0] = 0;
        consumed[1] = 10; // 把消费的距离放进去
        Log.d(TAG, "----父布局onNestedPreScroll----------------");
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        Log.d(TAG, "----父布局onNestedFling----------------");
        return true;
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        Log.d(TAG, "----父布局onNestedPreFling----------------");
        return true;
    }

    @Override
    public int getNestedScrollAxes() {
        Log.d(TAG, "----父布局getNestedScrollAxes----------------");
        return mParentHelper.getNestedScrollAxes();
    }
}
