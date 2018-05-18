package com.zc.synch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.zc.mydemoin58.R;
import com.zc.util.ToastUtills;
import com.zc.util.UIUtil;

public class SynchActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText showET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synch);
        showET = (EditText)this.findViewById(R.id.synch_edit);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.synch_clear:
                showET.setText("");
                break;
            case R.id.synch_oninstance:
                for (int i = 0;i<3;i++){
                    final String tag = "第"+i+"个线程";
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            SynchEntry se = new SynchEntry();
                            se.showADD(showET,tag);
                        }
                    }).start();
                }
                break;
            case R.id.synch_onstatic:
                for (int i = 0;i<3;i++){
                    final String tag = "第"+i+"个线程";
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            SynchEntry.showStaticADD(showET,tag);
                        }
                    }).start();
                }
                break;
            case R.id.synch_wait_notify:
                for (int i = 0;i<3;i++){
                    final String tag = "第"+i+"个线程";
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            new SynchEntry().waitAddNotify(showET,tag);
                        }
                    }).start();
                }
                break;
            case R.id.synch_lock:
                final SynchEntry se = new SynchEntry();
                for (int i = 0;i<10;i++){
                    final String tag = "第"+i+"个线程";
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            se.lock(showET,tag);
                        }
                    }).start();
                }
                break;
        }
    }
}
