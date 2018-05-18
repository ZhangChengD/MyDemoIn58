package com.zc.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by 张程 on 16/12/7.
 */

public class Envi {

    public static Application context;
    public static Thread uiThread;;


    public static void init(Application app){
        context = app;
        uiThread = Thread.currentThread();
    }

    public static int getStatusBarHeight() {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
