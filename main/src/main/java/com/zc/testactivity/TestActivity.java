package com.zc.testactivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zc.mydemoin58.R;
import com.zc.testactivity.mview.MyLinearLayout;

/**
 * 测试Activity的生命周期
 */

public class TestActivity extends FragmentActivity {

    private static String TAG = "TestActivity";
    private MyLinearLayout mLinearLayout, mLinearLayout1, mLinearLayout2;

    {
        Log.e(TAG, "code state");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.e(TAG, "onPostCreate");
//        ViewGroup contentParent = (ViewGroup)this.findViewById(R.id.content);
//        View content = contentParent.getChildAt(0);
//        contentParent.removeView(content);
//        TextView textView = new TextView(this);
//        textView.setText("adasd");
////        contentParent.addView(textView);
//        setContentView(textView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//        Log.e(TAG, "onCreate");
//        mLinearLayout = (MyLinearLayout) findViewById(R.id.test_activity_lay);
//        mLinearLayout1 = (MyLinearLayout) findViewById(R.id.test_activity_lay_2);
//        mLinearLayout2 = (MyLinearLayout) findViewById(R.id.test_activity_lay_3);
//        initListener();
        ViewGroup view = (ViewGroup) findViewById(android.R.id.content);
        view.removeAllViews();
        view.setBackgroundColor(Color.GRAY);
    }

    private void initListener() {
        mLinearLayout.id = 1;
        mLinearLayout1.id = 2;
        mLinearLayout2.id = 3;
        mLinearLayout1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e(TAG, 2 + " -- TouchListener" + event.getAction());
                return true;
            }
        });
        mLinearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e(TAG, 1 + " -- TouchListener" + event.getAction());
                return false;
            }
        });
        mLinearLayout2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e(TAG, 3 + " -- TouchListener" + event.getAction());
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Log.e(TAG, "onResume");
//        Intent intent = new Intent();
//        intent.setClass(TestActivity.this, Test2Activity.class);
//        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.e("zc", "onCreateOptionsMenu");
        return true;
    }
}
