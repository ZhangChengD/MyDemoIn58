package com.zc.expandlv;

import android.icu.text.IDNA;
import android.util.Log;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by 张程 on 17/7/7.
 */

public class InfoManager {

    private static InfoManager mInfoManager;

    private InfoManager() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        for (int i = 0; i < infos.size(); i++) {
                            if (infos.get(i).get() != null) {
                                infos.get(i).get().showInfo();
                            }
                        }
                    } catch (Exception e) {
                        Log.e("zc", e.getMessage());
                    }
                }
            }
        }).start();
    }

    public static InfoManager getInstance() {
        synchronized (InfoManager.class) {
            if (mInfoManager == null) {
                mInfoManager = new InfoManager();
            }
        }
        return mInfoManager;
    }

    private ArrayList<SoftReference<InfoZC>> infos = new ArrayList<>();

    public void addInfo(SoftReference<InfoZC> infoZC) {
//        WeakReference<InfoZC> zc = new WeakReference<InfoZC>(infoZC);
        infos.add(infoZC);
    }

    public static interface InfoZC {
        void showInfo();
    }
}
