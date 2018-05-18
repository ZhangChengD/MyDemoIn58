package com.zc.statusbar;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.zc.mydemoin58.R;

public class StatusBarActivity extends AppCompatActivity {

    private View statusBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_bar);
        initview();
    }

    public void initview(){
        getWindow().setStatusBarColor(Color.BLUE);
        initStatusBar();
    }

    private void initStatusBar(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(Color.WHITE);
            int flag = getWindow().getDecorView().getSystemUiVisibility();

            //需要黑色字体
            if (true) {
//"https://developer.android.com/reference/android/R.attr.html#windowLightStatusBar"


                flag |= (WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS

                        | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }

            //是否需要透明状态栏
            if (true) {
//改变字体颜色
                flag |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            }

            getWindow().getDecorView().setSystemUiVisibility(flag);

            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }
    }
}
