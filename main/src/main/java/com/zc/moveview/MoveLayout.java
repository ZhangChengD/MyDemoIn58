package com.zc.moveview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.zc.mydemoin58.R;

/**
 * Created by 张程 on 17/4/20.
 */

public class MoveLayout extends RelativeLayout {

    protected LayoutInflater inflater;
    private int lastX;
    private int lastY;
    private View convertView;

    private View delView;
    private View tagView;
    private View rotateView;
    private RelativeLayout.MarginLayoutParams layoutParams;

    private float w = 0;

    private float nowRoyation = 0;

    private OnTouchListener moveListener, rotateListener;

    public MoveLayout(Context context) {
        this(context, null);
    }

    public MoveLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MoveLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflater = LayoutInflater.from(context);
        initView();
        addView(convertView, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void initView() {
        initListener();

        convertView = inflater.inflate(R.layout.move_lay, null);
        delView = convertView.findViewById(R.id.move_del);
        delView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveLayout.this.setVisibility(GONE);
            }
        });
        tagView = convertView.findViewById(R.id.move_tag);
        tagView.setOnTouchListener(moveListener);
        rotateView = convertView.findViewById(R.id.move_rotate);
        rotateView.setOnTouchListener(rotateListener);

    }

    private void initListener() {

        moveListener = new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
                        layoutParams = (RelativeLayout.MarginLayoutParams) getLayoutParams();
                        int left = layoutParams.leftMargin + x - lastX;
                        int top = layoutParams.topMargin + y - lastY;

                        layoutParams.leftMargin = left;
                        layoutParams.topMargin = top;
                        setLayoutParams(layoutParams);
                        requestLayout();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        break;
                    }
                }
                lastX = x;
                lastY = y;
                return true;
            }
        };

        rotateListener = new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();

                if (w >= 0) {
                    w = MoveLayout.this.getWidth();
                }
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        break;
                    }

                    case MotionEvent.ACTION_MOVE: {
                        double changeX = x - lastX;
                        double changeY = y - lastY;
                        double changel = Math.sqrt(changeX * changeX + changeY * changeY);
                        double r = Math.asin(changel * (double) 2 / w);
                        double f = ((float) 1.5) * r / Math.PI * ((float) 180);
                        nowRoyation = (nowRoyation + (float) 360) % (float) 360;

                        if (nowRoyation < 15 || nowRoyation > 345) {
                            if (changeY >= 0) {

                            } else if (changeY < 0) {
                                f = -f;
                            }
                        } else if (nowRoyation < 75) {
                            if (changeX <= 0 && changeY >= 0) {

                            } else if (changeX > 0 && changeY < 0) {
                                f = -f;
                            } else {
                                f = 0.0;
                            }
                        } else if (nowRoyation < 105) {
                            if (changeX <= 0) {

                            } else if (changeX > 0) {
                                f = -f;
                            }
                        } else if (nowRoyation < 165) {
                            if (changeX <= 0 && changeY <= 0) {

                            } else if (changeX > 0 && changeY > 0) {
                                f = -f;
                            } else {
                                f = 0.0;
                            }
                        } else if (nowRoyation < 195) {
                            if (changeY <= 0) {

                            } else if (changeY > 0) {
                                f = -f;
                            }
                        } else if (nowRoyation < 255) {
                            if (changeX >= 0 && changeY <= 0) {

                            } else if (changeX < 0 && changeY > 0) {
                                f = -f;
                            } else {
                                f = 0.0;
                            }
                        } else if (nowRoyation < 285) {
                            if (changeX >= 0) {

                            } else if (changeX < 0) {
                                f = -f;
                            }
                        } else {
                            if (changeX >= 0 && changeY >= 0) {

                            } else if (changeX < 0 && changeY < 0) {
                                f = -f;
                            } else {
                                f = 0.0;
                            }
                        }
                        nowRoyation += f;
                        MoveLayout.this.setRotation(nowRoyation);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        break;
                    }

                }
                lastX = x;
                lastY = y;
                return true;
            }
        };
    }


//    private boolean isTouchPointInView(View view, int x, int y) {
//        if (view == null) {
//            return false;
//        }
//        int[] location = new int[2];
//        view.getLocationOnScreen(location);
//        int left = location[0];
//        int top = location[1];
//        int right = left + view.getMeasuredWidth();
//        int bottom = top + view.getMeasuredHeight();
//        //view.isClickable() &&
//        if (y >= top && y <= bottom && x >= left
//                && x <= right) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        int x = (int) event.getRawX();
//        int y = (int) event.getRawY();
//
//        switch (event.getAction()) {
//
//            case MotionEvent.ACTION_DOWN: {
//                if (isTouchPointInView(delView, x, y)) {
//                    nowType = DELTYPE;
//                } else if (isTouchPointInView(rotateView, x, y)) {
//                    nowType = ROTATETYPE;
//                }
//                break;
//            }
//
//            case MotionEvent.ACTION_MOVE: {
//
//                if (nowType == MOVETYPE) {
//                    layoutParams = (RelativeLayout.MarginLayoutParams) getLayoutParams();
//                    int left = layoutParams.leftMargin + x - lastX;
//                    int top = layoutParams.topMargin + y - lastY;
//
//                    layoutParams.leftMargin = left;
//                    layoutParams.topMargin = top;
//                    setLayoutParams(layoutParams);
//                    requestLayout();
//                }
//                if (nowType == ROTATETYPE) {
//                    double w = this.getWidth();
//
//                    double changeX = x - lastX;
//                    double changeY = y - lastY;
//
//                    double changel = Math.sqrt(x * x + y * y);
//
//                    double r = Math.atan(changel / (float) w);
//                    double f = ((double) 2) * r;
//
//                    if (changeY < 0 && nowRoyation > -90 && nowRoyation < 90) {
//                        f = -f;
//                    }
//
//                    nowRoyation += f;
//
//                    Log.e("zc", nowRoyation + "");
//                    nowRoyation = nowRoyation % 360;
//                    this.setRotation(nowRoyation);
//                }
//                break;
//            }
//
//            case MotionEvent.ACTION_UP: {
//
//                if (nowType == DELTYPE && isTouchPointInView(delView, x, y)) {
//                    this.setVisibility(GONE);
//                } else {
//                    nowType = MOVETYPE;
//                }
//                break;
//            }
//
//        }
//        lastX = x;
//        lastY = y;
//        return true;
//    }
}
