package com.zc.tabtop3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zc.mydemoin58.R;
import com.zc.tabtop2.TabTop2RVAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张程 on 17/4/21.
 */

public class TapTop3Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tabtop3frag_lay, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    View view;
    RecyclerView mRecyclerView;

    private void initView() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.tab_top3_lv);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("sss" + i);
        }
        TabTop2RVAdapter adapter = new TabTop2RVAdapter(list, getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }
}
