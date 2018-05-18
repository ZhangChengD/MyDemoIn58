package com.zc.nest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zc.mydemoin58.R;

import java.util.ArrayList;
import java.util.List;

public class NestActivity extends Activity {

    private ListView mlistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nest);
        initLV();
    }

    private void initLV(){
        mlistView = (ListView)findViewById(R.id.nest_lv);
        mlistView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData()));
    }

    private List<String> getData(){

        List<String> data = new ArrayList<String>();
        for (int i=0;i<30;i++){
            data.add("测试数据"+i);
        }
        return data;
    }

}
