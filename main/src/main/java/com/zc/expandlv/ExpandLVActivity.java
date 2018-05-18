package com.zc.expandlv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zc.mydemoin58.R;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ExpandLVActivity extends AppCompatActivity {
    private InfoManager.InfoZC zc1 = new InfoManager.InfoZC() {
        @Override
        public void showInfo() {
            Log.e("zc", "show");
        }
    };
    private SoftReference<InfoManager.InfoZC> zc = new SoftReference<InfoManager.InfoZC>(new InfoManager.InfoZC() {
        @Override
        public void showInfo() {
            Log.e("zc", "show");
        }
    }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_lv);
        InfoManager.getInstance().addInfo(zc);
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        while (true) {
//                            try {
//                                Thread.sleep(500);
//                                Log.e("zc","500");
//                                zc.get().showInfo();
//                            } catch (Exception e) {
//                                Log.e("zc", e.getMessage());
//                            }
//                        }
//                    }
//                }).start();
    }
}
