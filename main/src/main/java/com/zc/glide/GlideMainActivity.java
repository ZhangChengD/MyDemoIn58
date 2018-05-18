package com.zc.glide;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.zc.glide.adapter.GlideViewAdapter;
import com.zc.glide.bean.GlideImageBean;
import com.zc.glide.utils.ImageManager;
import com.zc.mydemoin58.R;

import java.util.ArrayList;
import java.util.List;

public class GlideMainActivity extends Activity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_main);
        initRV();
        ImageView imageView = (ImageView) findViewById(R.id.glide_main_image_view);
        ImageManager.showImage(this,imageView,"http://img03.sogoucdn.com/app/a/100520093/803d8006b5d521bb-2eb356b9e8bc4ae6-3711a88f93687dda52f52985564c93fb.jpg");
    }

    private void initRV(){
        mRecyclerView = (RecyclerView) this.findViewById(R.id.glide_main_recycler_view);
        GlideViewAdapter adapter = new GlideViewAdapter(GlideMainActivity.this);
        mRecyclerView.setAdapter(adapter);
        List<GlideImageBean> list = new ArrayList<>();
        GlideImageBean bean = new GlideImageBean();
        bean.setImageURl("http://img03.sogoucdn.com/app/a/100520093/803d8006b5d521bb-2eb356b9e8bc4ae6-3711a88f93687dda52f52985564c93fb.jpg");
        list.add(bean);
        GlideImageBean bean1 = new GlideImageBean();
        bean1.setImageURl("http://img03.sogoucdn.com/app/a/100520093/ca86e620b9e623ff-e7ae36db714776c0-d8f7ddb479faf01cdb180b1d69a99cf7.jpg");
        list.add(bean1);
        adapter.setDatas(list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }
}
