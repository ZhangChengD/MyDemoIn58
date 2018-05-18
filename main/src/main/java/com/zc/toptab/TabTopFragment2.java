package com.zc.toptab;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zc.mydemoin58.R;
import com.zc.util.ToastUtills;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class TabTopFragment2 extends Fragment {

    private ListView mListView;

    static TabTopFragment2 newInstance() {
        TabTopFragment2 newFragment = new TabTopFragment2();
        return newFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_top2, container, false);
        mListView = (ListView) view.findViewById(R.id.tab_top_frag2_lv);
        initLV();
        return view;

    }

    private void initLV() {
        List<String> itemList = new ArrayList<>();
        for (int i = 0; i < 50; i++)
            itemList.add("item" + i + "asd");
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(itemList, getActivity());
        mListView.setAdapter(adapter);
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

            ((TextView) convertView.findViewById(R.id.id_num)).setText(itemList.get(position));

            return convertView;
        }
    }

}
