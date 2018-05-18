package com.zc.anima;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.zc.mydemoin58.R;

public class AnimaActivity extends AppCompatActivity {

    private ImageView mImageView;
    private Button mBtnOne, mBtnTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anima);
        initView();
    }

    private void initView() {
        mImageView = (ImageView) findViewById(R.id.activity_anima_img);
        mImageView.setVisibility(View.GONE);
        mBtnOne = (Button) findViewById(R.id.activity_anima_button_one);
        mBtnTwo = (Button) findViewById(R.id.activity_anima_button_two);
        mBtnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        animaTypeOne();
                    }
                });
            }
        });
        mBtnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animaTypeTwo();
            }
        });
    }

    private void animaTypeOne() {

        AnimationSet animationSet = new AnimationSet(true);
        Animation scale1 = new ScaleAnimation(0.5f, 1.2f, 0.5f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale1.setDuration(2000);

        Animation scale2 = new ScaleAnimation(1.2f, 1f, 1.2f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale2.setDuration(1000);

        Animation scale3 = new ScaleAnimation(1f, 1f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale3.setDuration(7000);

        Animation alpha = new AlphaAnimation(1.0f, 0);
        alpha.setDuration(5000);

        animationSet.addAnimation(scale1);
        animationSet.addAnimation(scale2);
        animationSet.addAnimation(scale3);
        animationSet.addAnimation(alpha);

        mImageView.setAnimation(animationSet);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mImageView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mImageView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
//        animationSet.start();
        mImageView.startAnimation(animationSet);
    }

    private void animaTypeTwo() {

        AnimatorSet set = new AnimatorSet();

        Animator animator1 = new ObjectAnimator().ofFloat(mImageView, "scaleX", 0.5f, 1.2f);
        animator1.setDuration(200);
        Animator animator2 = new ObjectAnimator().ofFloat(mImageView, "scaleY", 0.5f, 1.2f);
        animator2.setDuration(200);

        Animator animator3 = new ObjectAnimator().ofFloat(mImageView, "scaleX", 1.2f, 1f);
        animator3.setDuration(100);
        Animator animator4 = new ObjectAnimator().ofFloat(mImageView, "scaleY", 1.2f, 1f);
        animator4.setDuration(100);

        Animator animator5 = new ObjectAnimator().ofFloat(mImageView, "scaleX", 1f, 1f);
        animator5.setDuration(700);

        Animator animator6 = new ObjectAnimator().ofFloat(mImageView, "alpha", 1f, 0);
        animator6.setDuration(500);

        set.play(animator1).with(animator2);
        set.play(animator3).with(animator4).after(animator1);
        set.play(animator5).after(animator3);
        set.play(animator6).after(animator5);

        animator6.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mImageView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        animator1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                mImageView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        set.start();
    }
}
