package com.zc.testdb;

import android.app.Activity;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.zc.mydemoin58.R;
import com.zc.testdb.dbhelper.MyDBHelper;

public class TestDBActivity extends Activity {

    private Button mAddBtn, mShowBtn;
    private MyDBHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("sssssssssss------------");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_test_db);
        mDBHelper = MyDBHelper.getInstance(this);
        mAddBtn = (Button) findViewById(R.id.test_db_add);
        mShowBtn = (Button) findViewById(R.id.test_db_show);
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDBHelper.insertInto("北京", "北京");
            }
        });
        mShowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mDBHelper.getInfo();
                mDBHelper.getInfoByAssets();
            }
        });
    }

}
