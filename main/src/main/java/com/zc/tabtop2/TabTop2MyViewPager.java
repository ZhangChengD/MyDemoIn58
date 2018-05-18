package com.zc.tabtop2;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.Animation;

/**
 * Created by 张程 on 17/4/21.
 */

public class TabTop2MyViewPager extends ViewPager {

    private Context mContext;

    public TabTop2MyViewPager(Context context) {
        super(context);
        this.mContext = context;
    }

    public TabTop2MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    float ax = 0;
    float ay = 0;
    float ax2 = 0;
    float ay2 = 0;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                ax = ev.getX();
                ay = ev.getY();
                break;

            case MotionEvent.ACTION_MOVE:

                ax2 = ev.getX();
                ay2 = ev.getY();
                if (ax != 0 && ax2 != 0 && ay != 0 && ay2 != 0) {
                    if (Math.abs(ay2 - ay) > Math.abs(ax2 - ax)) {
                        ((TabTop2Activity) mContext).setMove((ay - ay2));
                    }
                    Log.e("zc", "" + (ay - ay2));
                    ax = ax2;
                    ay = ay2;
                }
                break;

            case MotionEvent.ACTION_UP:
                ax = 0;
                ay = 0;
                break;
        }

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }
}
