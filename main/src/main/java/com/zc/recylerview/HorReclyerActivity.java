package com.zc.recylerview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zc.mydemoin58.R;
import com.zc.util.ToastUtills;

import java.util.ArrayList;
import java.util.List;

import static android.widget.NumberPicker.OnScrollListener.SCROLL_STATE_IDLE;

public class HorReclyerActivity extends Activity {

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_reclyer);
        initRecycler();
        initMyView();
    }

    private void initRecycler() {
        mRecyclerView = (RecyclerView) findViewById(R.id.hor_reclyer_rv);
        List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lists.add(i);
        }
        mAdapter = new MyAdapter(lists);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int state) {
                super.onScrollStateChanged(recyclerView, state);

                if (state == RecyclerView.SCROLL_STATE_DRAGGING) {
                    mAdapter.setSelected(-1);
                } else if (state == RecyclerView.SCROLL_STATE_IDLE) {
                    setChecked();
                }
            }

        });
    }

    private void initMyView() {
        HorizontalselectedView hsMain = (HorizontalselectedView) findViewById(R.id.hor_reclyer_v);
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add(i + "00");
        }
        hsMain.setData(strings);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        setChecked();
    }

    private void setChecked() {
        LinearLayoutManager layoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        int first = layoutManager.findFirstVisibleItemPosition();
        int end = layoutManager.findLastVisibleItemPosition();
        Log.e("zc", "first and end :" + first + "--" + end);
        mAdapter.setSelected((first + end) / 2);
    }

    private class MyAdapter extends RecyclerView.Adapter<MyHolder> {

        int selected = -1;
        List<Integer> mDatas = new ArrayList<>();

        MyAdapter(List<Integer> mDatas) {
            super();
            this.mDatas = mDatas;
        }

        public void setSelected(int selected) {
            this.selected = selected;
            if (selected == -1) {
                notifyDataSetChanged();
            } else {
                notifyItemChanged(selected);
            }
        }

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView tv = new TextView(HorReclyerActivity.this);
            tv.setTextSize(25);
            tv.setLayoutParams(new ViewGroup.LayoutParams(100, ViewGroup.LayoutParams.WRAP_CONTENT));
            MyHolder holder = new MyHolder(tv);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            if (position == selected) {
                holder.tv.setTextColor(Color.GREEN);
            } else {
                holder.tv.setTextColor(Color.BLACK);
            }
            holder.tv.setText(mDatas.get(position) + "");
        }


        @Override
        public int getItemCount() {
            return mDatas.size();
        }
    }

    private class MyHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView;
        }
    }

}
