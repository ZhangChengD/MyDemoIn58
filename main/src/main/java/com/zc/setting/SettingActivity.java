package com.zc.setting;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zc.mydemoin58.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.setting_GJ:
                Uri uri = Uri.parse("package:"+"com.ganji.android");
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,uri);
                startActivity(intent);
                break;
            case R.id.setting_My:
                Uri uri1 = Uri.parse("package:"+"com.zc.mydemoin58");
                Intent intent1 = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,uri1);
                startActivity(intent1);
                break;
            case R.id.setting_USAGE_ACCESS_SETTINGS:
            Intent intent2 = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
            startActivity(intent2);
            break;
        }
    }
}
