package com.zc.constrainlay;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zc.mydemoin58.R;
import com.zc.toptab.TabTopFragment2;
import com.zc.util.ToastUtills;

import java.util.ArrayList;
import java.util.List;

import static android.renderscript.ScriptIntrinsicBLAS.LEFT;
import static android.renderscript.ScriptIntrinsicBLAS.RIGHT;

public class ConstraintLayoutActivity extends AppCompatActivity {

    private ListView mListView;
    private View mView;
    private String TAG = "zc";
    private boolean isShow = false;
    private static final int TIME = 500;

    private long lastTime = 0;
    private boolean isClick = false;

    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);
        initLV();
    }

    private void initST() {
        mDetector = new GestureDetectorCompat(this, new MyGestureListener());
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            if (event1.getX() - event2.getX() < -20 && Math.abs(velocityX) > 0) {
                Log.e("zc", "右划");
            }
            return true;
        }
    }

    private void initLV() {

        mView = findViewById(R.id.tab_top_frag2_button);

        mListView = (ListView) findViewById(R.id.tab_top_frag2_lv);
        List<String> itemList = new ArrayList<>();
        for (int i = 1; i < 100; i++)
            itemList.add("item" + i + "asd");
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(itemList, this);
        mListView.setAdapter(adapter);
        initListener();
        initST();
        mView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mDetector.onTouchEvent(event);

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:

                        if (System.currentTimeMillis() - lastTime < 500) {
                            Log.e("zc", "双击");
                            isClick = true;
                            lastTime = 0;
                        } else {
                            lastTime = System.currentTimeMillis();
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(550);
                                        if (!isClick) {
                                            Log.e("zc", "单击");
                                        }
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    } finally {
                                        isClick = false;
                                    }
                                }
                            }).start();
                        }

                        break;
                }
                return true;
            }
        });
    }

    public void CheckHeight() {
        int firstPos = mListView.getFirstVisiblePosition();
        int list = mListView.getLastVisiblePosition();

        int h = mListView.getHeight();
        int high = 0;
        int index = -1;
        for (int i = 0; i < list - firstPos + 1; i++) {
            View itemView = mListView.getChildAt(i);
            if (itemView != null) {
                if (i == 0) {
                    if (high < (itemView.getHeight() + itemView.getTop())) {
                        high = itemView.getHeight() + itemView.getTop();
                        Log.e("zc", high + "**" + i);
                        index = i;
                    }
                } else if (i == list - firstPos) {
                    if (high < (h - itemView.getTop())) {
                        high = h - itemView.getTop();
                        Log.e("zc", high + "**" + i);
                        index = i;
                    }
                } else {
                    if (high < (itemView.getHeight())) {
                        high = itemView.getHeight();
                        Log.e("zc", high + "**" + i);
                        index = i;
                    }
                }
            }
        }

        Log.e("zc", firstPos + "****" + list + "****" + index);

    }

    private void initListener() {
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Log.e(TAG, "onScrollStateChanged------" + scrollState);
                switch (scrollState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE://空闲状态
//                        Log.e("zc", "空闲状态SCROLL_STATE_IDLE");
                        CheckHeight();
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING://滚动状态
//                        Log.e("zc", "滚动状态SCROLL_STATE_FLING");
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL://触摸后滚动
//                        Log.e("zc", "触摸后滚动SCROLL_STATE_TOUCH_SCROLL");
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, final int firstVisibleItem, final int visibleItemCount, int totalItemCount) {


                final int h = mView.getHeight();

                for (int i = 0; i < visibleItemCount; i++) {
                    View first = mListView.getChildAt(i);
                    if (first != null) {
                        if (i == 0) {
//                            Log.e(TAG, i + "high------>" + (first.getHeight() + first.getTop()));
                        } else if (i == visibleItemCount - 1) {
//                            Log.e(TAG, i + "high------>" + (mListView.getHeight() - first.getTop()));
                        } else {
                        }
                    }
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (firstVisibleItem + visibleItemCount >= 10 && !isShow) {
                            isShow = true;
                            Animation animation = new TranslateAnimation(0, 0, h, 0);
                            animation.setDuration(TIME);
                            animation.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {
                                    mView.setVisibility(View.VISIBLE);
                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {

                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                            mView.startAnimation(animation);
                        } else if (firstVisibleItem + visibleItemCount < 10 && isShow) {
                            isShow = false;
                            Animation animation = new TranslateAnimation(0, 0, 0, h);
                            animation.setDuration(TIME);
                            animation.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    mView.setVisibility(View.GONE);
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                            mView.startAnimation(animation);
                        }
                    }
                });
            }
        });
    }

    class MyRecyclerAdapter extends BaseAdapter {

        private List<String> itemList;
        private LayoutInflater inflater;

        public MyRecyclerAdapter(List<String> itemList, Activity activity) {
            this.itemList = itemList;
            inflater = activity.getLayoutInflater();
        }

        @Override
        public int getCount() {
            return itemList.size();
        }

        @Override
        public Object getItem(int position) {
            return itemList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.recycler_item2, null);
            }
            if (position % 2 == 0) {
                convertView.setBackgroundColor(Color.WHITE);
            } else {
                convertView.setBackgroundColor(Color.YELLOW);
            }
            ((TextView) convertView.findViewById(R.id.id_num)).setText(itemList.get(position));
            return convertView;
        }
    }
}