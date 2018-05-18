package com.zc.synch;

import android.widget.EditText;

import com.zc.util.UIUtil;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 张程 on 16/12/8.
 */

public class SynchEntry implements Runnable {

    public static synchronized void showStaticADD(final EditText editText, final String tag){
        try {
            for (int i = 0;i<10;i++){
                final String s = "    "+tag+"--->"+i+"\n";
                UIUtil.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        editText.setText(editText.getText()+s);
                    }
                });
                Thread.sleep(500);

            }
        }catch (Exception e){

        }
    }

    public synchronized void showADD(final EditText editText, final String tag){
        try {
            for (int i = 0;i<10;i++){
                final String s = "    "+tag+"--->"+i+"\n";
                UIUtil.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        editText.setText(editText.getText()+s);
                    }
                });
                Thread.sleep(500);

            }
        }catch (Exception e){

        }
    }

    public String TAG = "tag";

    public void waitAddNotify(final EditText editText, final String tag) {
        int i = 5;
        synchronized (TAG) {
            while (i > 0) {
                try {
                    final String s1 = " start" + tag + "--->" + i+"\n";
                    UIUtil.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            editText.setText(editText.getText() + s1);
                        }
                    });

                    TAG.notify();

                    final String s2 = " notyfy" + tag + "--->" + i+"\n";
                    UIUtil.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            editText.setText(editText.getText() + s2);
                        }
                    });
                    TAG.wait();
                    final String s3 = " wait" + tag + "--->" + i+"\n";
                    UIUtil.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            editText.setText(editText.getText() + s3);
                        }
                    });
                } catch(Exception e){
                }finally {
                    i--;
                }
            }
        }
    }

    Lock lock = new ReentrantLock();

    int count = 0;

    public void lock(final EditText editText, final String tag){
        try {
            lock.lock();
            final String s = "lock"+tag+"--->"+count+"\n";
            UIUtil.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    editText.setText(editText.getText()+s);
                }
            });
            Thread.sleep(500);
            final String s1 = "unlock"+tag+"--->"+count+"\n";
            UIUtil.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    editText.setText(editText.getText()+s1);
                }
            });
            count++;
        }catch (Exception e){
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {

    }
}
