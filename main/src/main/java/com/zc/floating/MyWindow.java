package com.zc.floating;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zc.mydemoin58.R;
import com.zc.util.Envi;
import com.zc.util.UIUtil;

/**
 * Created by 张程 on 17/1/6.
 */

public class MyWindow {

    private WindowManager mWindowManager;
    private TextView tvone, tvtwo, tvthree;
    private LinearLayout lay;
    private static MyWindow myWindow;

    public static MyWindow getInstance() {
        if (myWindow == null) {
            myWindow = new MyWindow();
        }
        return myWindow;
    }

    private MyWindow() {
        initView();
    }


    public void setText(final String s) {
        UIUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                lay.setVisibility(View.VISIBLE);
                tvone.setText(s);
            }
        });
    }

    private void initView() {
        if (mWindowManager == null) {
            mWindowManager = (WindowManager) Envi.context.getSystemService(Context.WINDOW_SERVICE);
        }
        LayoutInflater mInflater = LayoutInflater.from(Envi.context);
        lay = (LinearLayout) mInflater.inflate(R.layout.floating_lay, null);
        tvone = (TextView) lay.findViewById(R.id.floatin_one);
        tvtwo = (TextView) lay.findViewById(R.id.floatin_two);
        tvthree = (TextView) lay.findViewById(R.id.floatin_three);
        tvtwo.setVisibility(View.GONE);
        tvthree.setVisibility(View.GONE);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.type = WindowManager.LayoutParams.TYPE_TOAST;
        params.format = PixelFormat.RGBA_8888;
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        params.x = 20;
        params.y = 20;
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.LEFT | Gravity.TOP;

        mWindowManager.addView(lay, params);
    }

    public void destory() {
        if (mWindowManager != null && lay != null)
            lay.setVisibility(View.GONE);
    }
}
