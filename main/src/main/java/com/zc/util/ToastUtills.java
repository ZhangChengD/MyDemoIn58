package com.zc.util;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zc.mydemoin58.R;

/**
 * Created by zc on 16/12/7.
 */

public class ToastUtills {

    public static Toast sToast;
    private static TextView tv;

    public static void showToast(final String msg) {
        showToast(msg, R.layout.default_toast_view);
    }

    public static void showToast(final String msg, final int resId) {
        showToast(msg, resId, Toast.LENGTH_SHORT);
    }

    public static void showToast(final String msg, final int resId, final int dura) {
        UIUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (sToast == null) {
                    sToast = new Toast(Envi.context);
                    LayoutInflater factory1 = LayoutInflater.from(Envi.context);
                    LinearLayout layoutview = (LinearLayout) factory1.inflate(resId, null);
                    tv = (TextView) layoutview.findViewById(R.id.toast_textview);
                    sToast.setView(layoutview);
                }
                tv.setText(msg);
                sToast.setDuration(dura);
                sToast.show();
            }
        });
    }

}
