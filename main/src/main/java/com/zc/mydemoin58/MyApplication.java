package com.zc.mydemoin58;

import android.app.Application;

import com.zc.util.Envi;

/**
 * Created by 张程 on 16/12/7.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Envi.init(this);
    }

}
