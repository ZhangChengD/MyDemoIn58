package com.zc.recylerview;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.zc.mydemoin58.R;
import com.zc.util.ToastUtills;

import java.util.ArrayList;
import java.util.List;

public class FansActivity extends Activity {

    private RecyclerView mRecyclerView;
    private List<String> lists;
    private LinearLayoutManager mLM;
    private MyRecyclerAdapter myAdapter;
    private boolean CAN_LOAD = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_fans);
        initRecyclerView();
    }

    private void initRecyclerView() {

        lists = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            lists.add("asd" + i);
        }
        mRecyclerView = (RecyclerView) this.findViewById(R.id.fans_recycler);
        myAdapter = new MyRecyclerAdapter();
        mLM = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLM);
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int visibleChildCount = mLM.getChildCount();

                if (visibleChildCount > 0 && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    View lastVisibleView = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
                    int lastVisiblePosition = recyclerView.getChildLayoutPosition(lastVisibleView);
                    if (lastVisiblePosition >= mLM.getItemCount() - 2) {
                        lists.add("加载更多1");
                        lists.add("加载更多2");
                        lists.add("加载更多3");
                        lists.add("加载更多4");
                        lists.add("加载更多5");
                        myAdapter.notifyDataSetChanged();
                    }
                }
            }
        });

        mRecyclerView.setAdapter(myAdapter);
    }

    class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(FansActivity.this).inflate(R.layout.recycler_item, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(lists.get(position));
        }

        @Override
        public int getItemCount() {
            return lists.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        View v;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.id_num);
            v = itemView.findViewById(R.id.id_divider);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtills.showToast(tv.getText() + "");
                }
            });
        }
    }

}
