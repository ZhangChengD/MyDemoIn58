package com.zc.floating;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.zc.mydemoin58.R;
import com.zc.util.ToastUtills;

public class FloatingActivity extends Activity implements View.OnClickListener {

    /**
     * 悬浮窗口需要权限
     * <uses-permission
     * android:name="android.permission.SYSTEM_ALERT_WINDOW"/>
     * <p>
     * activity队列获取的
     * <uses-permission android:name = "android.permission.GET_TASKS"/>
     */

    private Intent startIntent;
    private boolean isOpen = false;
    public static boolean isShow = true;
    private PackageManager pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating);
        startIntent = new Intent(FloatingActivity.this, FloatingService.class);
    }

    private void showFloating() {
        if (!isOpen) {
            startService(startIntent);
            isOpen = true;
            isShow = true;
        }
    }

    private void dismissFloating() {
        if (startIntent != null) {
            stopService(startIntent);
            isOpen = false;
            isShow = false;
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.floating_show:
                showFloating();
                break;
            case R.id.floating_dismiss:
                dismissFloating();
                break;
            case R.id.floating_setting:
                Intent intent = new Intent();
                intent.setAction("android.settings.ACCESSIBILITY_SETTINGS");
                startActivity(intent);
                break;
        }
    }
}
