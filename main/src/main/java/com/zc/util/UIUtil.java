package com.zc.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by 张程 on 16/12/7.
 */

public class UIUtil {

    private static ThreadPoolExecutor mThreadPool = new ThreadPoolExecutor(4, 8, 10000, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>());

    public static void runOnUiThread(Runnable action) {
        if (Thread.currentThread() != Envi.uiThread) {
            new Handler(Looper.getMainLooper()).post(action);
        } else {
            action.run();
        }
    }

    public static boolean isMainThread() {
        return Envi.uiThread == Thread.currentThread();
    }

    //high 必须是奇数
    public static void print(int high) {
        if (high % 2 == 0) {
            high--;
        }
        String s = "";
        int max = high;
        for (int i = 0; i < high; i++) {
            s = "";
            if (i <= high / 2) {
                for (int j = 0; j < max; j++) {
                    if (j < max - (2 * i + 1)) {
                        s += " ";
                    } else {
                        s += "*";
                    }
                }
            } else {
                for (int j = 0; j < max; j++) {
                    if (j < 2 * (max - i) - 1) {
                        s += "*";
                    }
                }
            }
            Log.e("zc", s);
        }
    }

    public static void asynchDo(Runnable runnable){
        mThreadPool.execute(runnable);
    }
}
