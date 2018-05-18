package com.zc.viewconstructor;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.zc.mydemoin58.R;

/**
 * Created by 张程 on 17/7/11.
 */

public class TestConstructorView extends View {

    public TestConstructorView(Context context) {
        super(context);
        Log.e("zc", "TestConstructorView(Context context)");
    }

    public TestConstructorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TestConstructorView);
        int max = a.getResourceId(R.styleable.TestConstructorView_my_max, 0);
        Log.e("zc", "TestConstructorView(Context context, AttributeSet attrs)");
        String attrString = "";
        for (int i = 0; i < attrs.getAttributeCount(); i++) {
            attrString += attrs.getAttributeName(i) + "=" + attrs.getAttributeValue(i) + "\n";
        }
        Log.e("zc", attrString);

    }

    public TestConstructorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.e("zc", "TestConstructorView(Context context, AttributeSet attrs, int defStyleAttr)");
    }

}
