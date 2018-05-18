package com.zc.tabtop3;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.zc.mydemoin58.R;
import com.zc.util.ToastUtills;
import com.zc.util.UIUtil;


public class TabTop3Activity extends FragmentActivity {

    private ViewPager mViewPager;

    private TextView mTextView;
    private LinearLayout mLinearLayout;
    private static boolean isInit = false;
    private RadioGroup mRadioGroup;
    private LinearLayout linearLayout;
    private boolean isMeasured = false;
    private SuspendScrollView mSuspendScrollView;
    private LinearLayout RefreshHeadView;
    private TextView mHorizontalListView;
    private TextView mSupListView;
    private ImageView imageView;
    private LinearLayout mScrollContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_top3);
        initViewPager();
    }


    private void initViewPager() {
        mScrollContainer = (LinearLayout) findViewById(R.id.scrollview_container);
        mLinearLayout = (LinearLayout) findViewById(R.id.home_banner_header);//广告头的总布局;
        mViewPager = (ViewPager) findViewById(R.id.home_viewpager);
        mHorizontalListView = (TextView) findViewById(R.id.user); //非悬浮导航
        mSupListView = (TextView) findViewById(R.id.Sup); //悬浮导航
        Constant.MY_INDICATOR = mSupListView;
        imageView = (ImageView) findViewById(R.id.myimage);
        RefreshHeadView = (LinearLayout) findViewById(R.id.scrollView_refresh_head);
        mSuspendScrollView = (SuspendScrollView) findViewById(R.id.home_scrollview);
        //接受参数
        mSuspendScrollView.setView(mLinearLayout, mSupListView, RefreshHeadView, mHorizontalListView, mScrollContainer);
        mSuspendScrollView.setOnRefreshScrollViewListener(new SuspendScrollView.OnRefreshScrollViewListener() {
            @Override
            public void onRefresh() {
                ToastUtills.showToast("下拉刷新");
            }

            /**
             * 刷新完成时需要的操作  更新UI等
             */
            @Override
            public void onRefreshFinish() {
                ToastUtills.showToast("刷新完成");
            }
        });
        mViewPager.setAdapter(new TabTop3Adapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(2);//设置预加载 防止切换时状态丢失
//        setViewpagerHeight(mViewPager);
//        initIndicator();
    }

//    private void initIndicator() {
//        mLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                if (!isInit) {
//                    int top = mHorizontalListView.getTop();
//                    int height = mHorizontalListView.getHeight();
////                    mSupListView.layout(0, top, mSupListView.getWidth(), top + height);
//                }
//            }
//        })
//    }
//    private void setViewpagerHeight(final ViewPager mViewPager) {
//        mRadioGroup = mHomeActivity.getRadioGroup();
//        linearLayout = mHomeActivity.getHomeActivityLinearLayout();
//        linearLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
//            @Override
//            public boolean onPreDraw() {
//                if (!isMeasured) {
//                    int height = linearLayout.getHeight() - mRadioGroup.getHeight() - mHorizontalListView.getHeight();
//                    LinearLayout.LayoutParams llparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                            height);
//                    mViewPager.setLayoutParams(llparams);
//                    LogUtils.w("是---------------------dp=" + UiUtils.px2dip(imageView.getHeight()));
//                    isMeasured = true;
//                }
//                return true;
//            }
//        });
//
//    }

}
