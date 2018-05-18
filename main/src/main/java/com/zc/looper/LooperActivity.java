package com.zc.looper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zc.mydemoin58.R;
import com.zc.util.UIUtil;

public class LooperActivity extends AppCompatActivity implements Handler.Callback {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looper);
        layout = (LinearLayout) findViewById(R.id.activity_looper);
    }

    public void onClickLooper(View v) {
        switch (v.getId()) {
            case R.id.mainLooper:
                initMainLooper();
                break;
            case R.id.threedLooper:
                initThreadaLooper();
                break;
        }
    }

    public void initMainLooper() {
        Message msg = Message.obtain();
        Handler handler = new Handler(Looper.getMainLooper(), this);
        msg.obj = "Handler handler = new Handler(Looper.getMainLooper(),this)";
        handler.sendMessage(msg);
    }

    Handler threadhandler;

    public void initThreadaLooper() {
        //方式一
//        HandlerThread thread = new HandlerThread("zc");
//        thread.start();
//        Handler handler2 = new Handler(thread.getLooper(),this);
//        Message msg = Message.obtain();
//        msg.obj = "Handler handler2 = new Handler(this)";
//        handler2.sendMessage(msg);

        //方法2
        if (threadhandler == null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Looper.prepare();
                    threadhandler = new Handler(Looper.myLooper(), LooperActivity.this);
                    Looper.loop();
                    Message msg = Message.obtain();
                    msg.obj = "Handler handler2 = new Handler(this)";
                    threadhandler.sendMessage(msg);
                }
            }).start();
        } else {
            Message msg = Message.obtain();
            msg.obj = "Handler handler2 = new Handler(this)";
            threadhandler.sendMessage(msg);
        }
    }

    TextView tv;

    @Override
    public boolean handleMessage(Message msg) {
        if (tv == null) {
            tv = new TextView(this);
            tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layout.addView(tv);
        }
        tv.requestFocus();
        tv.setText(tv.getText() + "/n" + msg.obj.toString() + "~~~~~~~" + (Looper.myLooper() == Looper.getMainLooper()));
        return false;
    }



}
