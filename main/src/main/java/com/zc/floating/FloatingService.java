package com.zc.floating;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.app.Service;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.SortedMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

public class FloatingService extends Service {

    private WindowManager mWindowManager;
    private ActivityManager am;
    private UsageStatsManager usm;
    private Timer timer;
    private MyWindow myWindow;

    public FloatingService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myWindow = MyWindow.getInstance();
        am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        usm = (UsageStatsManager) getSystemService(USAGE_STATS_SERVICE);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (timer == null) {
            timer = new Timer();
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                timer.scheduleAtFixedRate(new RefreshTask(), 0, 500);
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private String text = "";

    class RefreshTask extends TimerTask {
        @Override
        public void run() {
            String act = "";
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                List<ActivityManager.RunningTaskInfo> rtis = am.getRunningTasks(1);
                act = rtis.get(0).topActivity.getPackageName() + "\n"
                        + rtis.get(0).topActivity.getClassName();
            } else {
                act = getTopAppNameOver21();
            }
            if (act != null && !act.equals(text)) {
                text = act;
                myWindow.setText(text);
            }
        }
    }

    @TargetApi(21)
    private String getTopAppNameOver21() {
        String topAppName = null;
        String twoAppName = null;
        long nowtime = System.currentTimeMillis();
        List<UsageStats> lists = usm.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, nowtime - 1000 * 10, nowtime);
        SortedMap<Long, UsageStats> mySortedMap = new TreeMap<Long, UsageStats>();
        for (UsageStats usageStats : lists) {
            mySortedMap.put(usageStats.getLastTimeUsed(), usageStats);
        }
        if (mySortedMap != null && !mySortedMap.isEmpty()) {
            topAppName = mySortedMap.get(mySortedMap.lastKey()).getPackageName();
            twoAppName = mySortedMap.get(mySortedMap.get(mySortedMap.size()-2)).getPackageName();
        }
        return topAppName+"\\n"+twoAppName;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (myWindow != null) {
            myWindow.destory();
        }
        timer.cancel();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
