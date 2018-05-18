package com.zc.toptab;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
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

public class TabTopFragment extends Fragment {

    static TabTopFragment newInstance() {
        TabTopFragment newFragment = new TabTopFragment();
        return newFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_top, container, false);
        RecyclerView lv = (RecyclerView) view.findViewById(R.id.fragment_top_recycler);
        LinearLayoutManager mLM = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        lv.setNestedScrollingEnabled(false);
        lv.setLayoutManager(mLM);
        List<String> itemList = new ArrayList<>();
        for (int i = 0; i < 50; i++)
            itemList.add("item" + i + "asd");
        lv.setAdapter(new MyRecyclerAdapter(itemList, getActivity()));
        return view;

    }

    class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

        List<String> itemList;
        Activity activity;

        public MyRecyclerAdapter(List<String> itemList, Activity activity) {
            this.itemList = itemList;
            this.activity = activity;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(activity).inflate(R.layout.recycler_item, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            if (holder != null) {
                holder.tv.setText(itemList.get(position));
            }
        }

        @Override
        public int getItemCount() {
            return itemList.size();
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
