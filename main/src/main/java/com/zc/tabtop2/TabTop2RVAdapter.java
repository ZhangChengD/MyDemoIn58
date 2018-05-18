package com.zc.tabtop2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zc.mydemoin58.R;

import java.util.List;

/**
 * Created by 张程 on 17/4/21.
 */

public class TabTop2RVAdapter extends RecyclerView.Adapter<TabTop2RVAdapter.MyHolder> {

    private List<String> stringList;
    private Context mContext;

    public TabTop2RVAdapter(List<String> stringList, Context mContext) {
        this.stringList = stringList;
        this.mContext = mContext;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder myHolder = new MyHolder(LayoutInflater.from(mContext).inflate(R.layout.activity_tab_top2_item, parent, false));
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.onBind(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.item_tv_tabtop2);
        }

        public void onBind(String s) {
            tv.setText(s);
        }
    }
}
