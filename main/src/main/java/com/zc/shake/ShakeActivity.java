package com.zc.shake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.zc.mydemoin58.R;

public class ShakeActivity extends AppCompatActivity {

    private Button btn;
    private View shakeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        btn = (Button) findViewById(R.id.shake_btn);
        shakeView = findViewById(R.id.shake_img);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation shakeAnim = AnimationUtils.loadAnimation(ShakeActivity.this, R.anim.slight_hor_shake);
                shakeView.startAnimation(shakeAnim);
            }
        });
    }
}
