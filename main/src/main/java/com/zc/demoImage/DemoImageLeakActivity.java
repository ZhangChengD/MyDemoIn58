package com.zc.demoImage;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.zc.mydemoin58.R;

public class DemoImageLeakActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_image_leak);
        findViewById(R.id.demo_image_invisiable_btn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        (findViewById(R.id.demo_image_invisiable))
                                .setVisibility(View.GONE);
                    }
                });
        findViewById(R.id.demo_image_gone_btn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageView imageView = (ImageView) findViewById(R.id.demo_image_gone);
                        imageView.setVisibility(View.GONE);
                        imageView.setImageBitmap(null);

                    }
                });
    }

}
