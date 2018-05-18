package com.zc.ivReclcy;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zc.mydemoin58.R;

public class TestIvReclcyActivity extends Activity {

    private Button mGoneBtn, mInvisableBtn, mReclcyBtn, mReclcyResetBtn;
    private ImageView mTestIv1, mTestIv2, mTestIv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_test_iv_reclcy);
        mTestIv1 = (ImageView) findViewById(R.id.test_iv_reclcy_iv);
        mTestIv2 = (ImageView) findViewById(R.id.test_iv_reclcy_iv_2);
        mTestIv3 = (ImageView) findViewById(R.id.test_iv_reclcy_iv_3);
        mGoneBtn = (Button) findViewById(R.id.test_iv_reclcy_gone);
        mInvisableBtn = (Button) findViewById(R.id.test_iv_reclcy_invisiable);
        mReclcyBtn = (Button) findViewById(R.id.test_iv_reclcy_reclcy);
        mReclcyResetBtn = (Button) findViewById(R.id.test_iv_reclcy_reclcy_reset);
        mGoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTestIv3.setVisibility(View.GONE);
                mTestIv3.setImageBitmap(null);
            }
        });
        mReclcyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTestIv1 != null && mTestIv1 instanceof ImageView) {
                    Drawable drawable = mTestIv1.getDrawable();
                    if (drawable instanceof BitmapDrawable) {
                        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                        if (bitmap != null && !bitmap.isRecycled()) {
                            mTestIv1.setImageBitmap(null);
                            bitmap.recycle();
                            bitmap = null;
                        }
                    }
                }
            }
        });


        mReclcyResetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTestIv3.setImageResource(R.drawable.icon_pull_2_refresh_light_3);
                mTestIv3.setVisibility(View.VISIBLE);
            }
        });

        mInvisableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTestIv2.setVisibility(View.INVISIBLE);
            }
        });
    }

    /**
     * 测试在ondestory中不调用popWindow的dismiss方法
     * 是否会导致内存泄漏
     */
    private void initPopWindow() {

    }

}
