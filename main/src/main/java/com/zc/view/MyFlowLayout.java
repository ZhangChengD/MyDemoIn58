package com.zc.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zc on 17/3/14.
 * 添加任意高度的childView,都会实现该行的水平居中.
 */

public class MyFlowLayout extends ViewGroup {

    private List<List<View>> mViewList = new ArrayList<>();
    private List<View> mViewLineList = new ArrayList<>();
    private List<Integer> mLineHight = new ArrayList<>();

    public MyFlowLayout(Context context) {
        super(context);
    }

    public MyFlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        int lineWidth = 0;
        int LineHigth = 0;

        int height = 0;
        int width = 0;

        mViewList.clear();
        mLineHight.clear();

        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            LayoutParams params = child.getLayoutParams();
            MarginLayoutParams mlp;

            if (params instanceof ViewGroup.MarginLayoutParams) {
                mlp = (ViewGroup.MarginLayoutParams) params;
            } else {
                mlp = new ViewGroup.MarginLayoutParams(params);
            }

            int childWidth = child.getMeasuredWidth() + mlp.leftMargin + mlp.rightMargin;
            int childHight = child.getMeasuredHeight() + mlp.topMargin + mlp.bottomMargin;
            if (lineWidth + childWidth > sizeWidth) {
                width = Math.max(lineWidth, width);
                lineWidth = childWidth;
                mLineHight.add(LineHigth);
                mViewList.add(mViewLineList);
                mViewLineList = new ArrayList<>();
                height = height + LineHigth;
                LineHigth = childHight;
            } else {
                lineWidth = lineWidth + childWidth;
                LineHigth = Math.max(LineHigth, childHight);
            }
            mViewLineList.add(child);
            if (i == getChildCount() - 1) {
                width = Math.max(width, lineWidth);
                height += LineHigth;
                mViewList.add(mViewLineList);
                mLineHight.add(LineHigth);
                mViewLineList = new ArrayList<>();
            }
        }

        setMeasuredDimension((modeWidth == MeasureSpec.EXACTLY) ? sizeWidth
                : width, (modeHeight == MeasureSpec.EXACTLY) ? sizeHeight
                : height);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int top = 0;
        int lineHeight;

        int lc, tc, rc, bc, childHeight;

        for (int i = 0; i < mViewList.size(); i++) {
            List<View> mList = mViewList.get(i);
            lineHeight = mLineHight.get(i);
            int left = 0;
            for (int j = 0; j < mList.size(); j++) {
                View child = mList.get(j);
                if (child.getVisibility() == View.GONE) {
                    continue;
                }
                LayoutParams params = child.getLayoutParams();
                MarginLayoutParams lp;

                if (params instanceof ViewGroup.MarginLayoutParams) {
                    lp = (ViewGroup.MarginLayoutParams) params;
                } else {
                    lp = new ViewGroup.MarginLayoutParams(params);
                }

                //计算childView的left,top,right,bottom

                lc = left + lp.leftMargin;

                childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
                //当控件高度不是该行高度是自动居中
                if (childHeight < lineHeight) {
                    tc = top + lp.topMargin + (lineHeight - childHeight) / 2;
                } else {
                    tc = top + lp.topMargin;
                }
                rc = lc + child.getMeasuredWidth();
                bc = tc + child.getMeasuredHeight();

                child.layout(lc, tc, rc, bc);

                left += child.getMeasuredWidth() + lp.rightMargin
                        + lp.leftMargin;
            }
            top += lineHeight;
        }

    }

}
