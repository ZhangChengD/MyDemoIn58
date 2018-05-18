package com.zc.multi;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zc.mydemoin58.R;

public class MultiViewFirstActivity extends Activity {

    ImageView mShareView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_view_first);
        mShareView = (ImageView) findViewById(R.id.multi_image);
        mShareView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiViewFirstActivity.this, MultiViewSecendActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions option = ActivityOptions
                            .makeSceneTransitionAnimation(MultiViewFirstActivity.this, mShareView, "multiView");
                    MultiViewFirstActivity.this.startActivity(intent, option.toBundle());
                } else {
                    MultiViewFirstActivity.this.startActivity(intent);
                }
            }
        });
    }
}
