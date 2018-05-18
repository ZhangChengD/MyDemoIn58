package com.zc.looper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zc.mydemoin58.R;

/**
 * Created by 张程 on 17/7/19.
 */

public class VideoView extends LinearLayout {

    private LayoutInflater mInflater;
    private RelativeLayout mLayout;

    public VideoView(Context context) {
        this(context, null);
    }

    public VideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(context);
        mInflater.inflate(R.layout.video_view_layout,this,true);
        initView();
    }

    public void initView(){
//        mLayout = (RelativeLayout) findViewById(R.id.video_lay);
    }
}
