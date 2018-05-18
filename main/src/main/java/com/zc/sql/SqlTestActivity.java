package com.zc.sql;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import com.zc.mydemoin58.R;
import com.zc.util.ToastUtills;
import com.zc.util.UIUtil;

import java.util.ArrayList;
import java.util.List;

public class SqlTestActivity extends AppCompatActivity {

    private DBDao mDBDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        mDBDao = new DBDao(this);
        Person person = new Person();
        person.setName("1");
        person.setAge(1);
        person.setSex("1");

        findViewById(R.id.sql_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIUtil.asynchDo(new Runnable() {
                    @Override
                    public void run() {
                        mDBDao.insert(person);
                    }
                });
            }
        });
        findViewById(R.id.sql_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIUtil.asynchDo(new Runnable() {
                    @Override
                    public void run() {
                        long old = System.currentTimeMillis();
                        for (int i=0;i<100;i++){
                            mDBDao.updata(person);
                        }
                        long cost = System.currentTimeMillis()-old;
                        Log.e("zcList",cost+" ----ONE BY ONE");
                        ToastUtills.showToast(cost+" ----ONE BY ONE");
                    }
                });
            }
        });
        findViewById(R.id.sql_updata_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIUtil.asynchDo(new Runnable() {
                    @Override
                    public void run() {
                        long old = System.currentTimeMillis();
                        List<Person> peoples = new ArrayList<>();
                        for (int i=0;i<100;i++) {
                            peoples.add(person);
                        }
                        mDBDao.updata(peoples);
                        long cost = System.currentTimeMillis()-old;
                        Log.e("zcList",cost+"----ALL");
                        ToastUtills.showToast(cost+"----ALL");
                    }
                });
            }
        });

    }

}
