package com.zc.mbitmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zc.mydemoin58.R;
import com.zc.util.UIUtil;

import static android.R.attr.bitmap;

public class BitmapActivity extends Activity {

    private LinearLayout mLinearLay;
    private Bitmap imageBitmap;
    private Button doBtn;
    private static Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        mLinearLay = (LinearLayout) findViewById(R.id.bitmap_linear);
        doBtn = (Button) findViewById(R.id.bitmap_btn);
        testBitmap();
        mActivity = this;
    }

    private void testBitmap() {
        imageBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.img_bitmap);
        testCopyBitmap();
//        testBitmap1();
//        testBitmap2();
//        testBitmap3();
//        testBitmap4();
//        testBitmap5();
    }

    private void testBitmap1() {
        ImageView mImageView = new ImageView(this);
        mImageView.setImageResource(R.drawable.img_bitmap);
        mLinearLay.addView(mImageView);
    }

    private void testBitmap2() {
        ImageView mImageView = new ImageView(this);

        try {
            Bitmap output = Bitmap.createBitmap(1000, 300, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);

            final Paint paint = new Paint();
            final Rect rect = new Rect(0, 0, 1000, 300);
            final RectF rectF = new RectF(rect);

            canvas.drawRoundRect(rectF, 50, 50, paint);

            mImageView.setImageBitmap(output);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mLinearLay.addView(mImageView);
    }

    private void testBitmap3() {
        ImageView mImageView = new ImageView(this);


        try {
            Bitmap output = Bitmap.createBitmap(imageBitmap.getWidth(), imageBitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);

            final Paint paint = new Paint();
            final Rect rect = new Rect(0, 0, 1000, 300);
            final RectF rectF = new RectF(rect);

            canvas.drawRoundRect(rectF, 100, 100, paint);

            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

            canvas.drawBitmap(imageBitmap, rect, rect, paint);

            mImageView.setImageBitmap(output);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mLinearLay.addView(mImageView);
    }

    private void testBitmap4() {
        ImageView mImageView = new ImageView(this);


        try {
            Bitmap output = Bitmap.createBitmap(imageBitmap.getWidth(), imageBitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);

            final Paint paint = new Paint();
            final Rect rect = new Rect(0, 0, 1000, 300);
            final RectF rectF = new RectF(rect);

            canvas.drawRoundRect(rectF, 100, 100, paint);

            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

            canvas.drawBitmap(imageBitmap, new Rect(), rect, paint);

            mImageView.setImageBitmap(output);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mLinearLay.addView(mImageView);
    }

    private void testBitmap5() {
        ImageView mImageView = new ImageView(this);


        try {
            Bitmap output = Bitmap.createBitmap(imageBitmap.getWidth(), imageBitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);

            final Paint paint = new Paint();
            final Rect rect = new Rect(0, 0, imageBitmap.getWidth(), imageBitmap.getHeight());
            final RectF rectF = new RectF(rect);

            canvas.drawRoundRect(rectF, 100, 100, paint);

            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

            canvas.drawBitmap(imageBitmap, rect, rect, paint);

            mImageView.setImageBitmap(output);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mLinearLay.addView(mImageView);
    }

    private void testCopyBitmap() {
        doBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIUtil.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Bitmap bCopy = imageBitmap.copy(Bitmap.Config.ARGB_8888, true);
                        ImageView mImageView = new ImageView(BitmapActivity.this);
                        mImageView.setImageBitmap(bCopy);
                        mLinearLay.addView(mImageView);
                    }
                });
            }
        });
    }
}
