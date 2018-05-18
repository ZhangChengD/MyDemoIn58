package com.zc.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 张程 on 17/2/14.
 */

public class TestFragment extends Fragment {
    private static final String TAG = "TestFragment";
    private static String hello;// = "hello android";
    private String defaultHello = "default value";
    private TextView mTVview;

    public static TestFragment newInstance(String s) {
        TestFragment newFragment = new TestFragment();
        Bundle bundle = new Bundle();
        bundle.putString("hello", s);
        newFragment.setArguments(bundle);
        hello = s;
        return newFragment;
    }

    public void bindView(String tvString) {
        Log.e("zc", " bindView ");
        if (mTVview != null) {
            mTVview.setText(tvString);
        }
    }

    public void initView() {
        Log.e("zc", " getActivity().finish(); ");
        if (getActivity() != null) {
            getActivity().finish();
        }
        return;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mTVview = new TextView(this.getActivity());
        initView();
        bindView(defaultHello);
        Log.e("zc", "id = " + this.hashCode());
        return mTVview;
    }


}