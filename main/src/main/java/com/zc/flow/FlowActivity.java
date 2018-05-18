package com.zc.flow;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zc.mydemoin58.R;
import com.zc.view.MyFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class FlowActivity extends Activity {

    private MyFlowLayout myflowLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);
        myflowLayout = (MyFlowLayout) findViewById(R.id.flow_viewgroup);
        initview();
    }


    private void initview() {
        String tag;
        int i = 0;
        int panding;
        for (; i < 44; i++) {
            tag = "a" + i;
            TextView tv = new TextView(this);
            panding = (int)(Math.random()*100);
            tv.setText(tag);
            ViewGroup.MarginLayoutParams mlp = new ViewGroup.MarginLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mlp.setMargins(10,10,10,10);
            tv.setLayoutParams(mlp);
            tv.setPadding(10, panding, 10, panding);
            tv.setBackgroundColor(Color.YELLOW);
            myflowLayout.addView(tv);
        }
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.img_bitmap);
        myflowLayout.addView(iv);
    }
}
