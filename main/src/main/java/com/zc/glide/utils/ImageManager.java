package com.zc.glide.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by 张程 on 18/2/28.
 */

public class ImageManager {

    public static void showImage(@NonNull Context context, @NonNull ImageView imageView, @NonNull String url) {
        if (TextUtils.isEmpty(url) || context == null || imageView == null) {
            return;
        }
        Glide.with(context)
                .load(url)
                .asBitmap()
                .into(imageView);
    }

}
