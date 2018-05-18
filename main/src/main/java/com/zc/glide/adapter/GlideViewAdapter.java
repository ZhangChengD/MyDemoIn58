package com.zc.glide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zc.glide.bean.GlideImageBean;
import com.zc.glide.utils.ImageManager;
import com.zc.mydemoin58.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张程 on 18/2/28.
 */

public class GlideViewAdapter extends RecyclerView.Adapter<GlideViewAdapter.ImageHolde> {

    private List<GlideImageBean> datas = new ArrayList<>();
    private Context mContext;

    public GlideViewAdapter(Context context) {
        mContext = context;
    }

    public void setDatas(List<GlideImageBean> images) {
        if (images != null && images.size() > 0) {
            datas.clear();
            datas.addAll(images);
            this.notifyDataSetChanged();
        }
    }

    @Override
    public ImageHolde onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageHolde(LayoutInflater.from(mContext).inflate(R.layout.lay_glide_image_item, null));
    }

    @Override
    public void onBindViewHolder(ImageHolde holder, int position) {
        if (holder != null && datas.size() > position) {
            ImageManager.showImage(mContext, holder.videoView, datas.get(position).getImageURl());
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ImageHolde extends RecyclerView.ViewHolder {

        public View mConvertView;
        public ImageView videoView;

        public ImageHolde(View itemView) {
            super(itemView);
            mConvertView = itemView;
            initView(itemView);
        }

        private void initView(View view) {
            videoView = (ImageView) view.findViewById(R.id.glide_main_recycler_item_img);
        }
    }
}
