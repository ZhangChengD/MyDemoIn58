package com.zc.design;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zc.design.ext.Father;
import com.zc.design.ext.Son;
import com.zc.mydemoin58.R;
import com.zc.util.ToastUtills;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DesignActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.design_father_son:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Map map = new LinkedHashMap();
                            HashMap hashMap = new HashMap();
                            Father far = new Father();
                            Father son = new Son();
                            far.say(hashMap);
                            Thread.sleep(1000);
                            son.say(map);
                            Thread.sleep(1000);
                            son.say(hashMap);
                            Thread.sleep(1000);
                            far.otherSay(hashMap);
                            Thread.sleep(1000);
                            son.otherSay(hashMap);
                        } catch (Exception e) {

                        }

                    }
                }).start();
                break;
            case R.id.design_toast:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Toast toast = new Toast(DesignActivity.this);
                        }catch (Exception e){
                            ToastUtills.showToast("Can't create handler inside thread that has not called Looper.prepare()\nwhen toast create will create hander by variable");
                        }
                    }
                }).start();
        }
    }
}
