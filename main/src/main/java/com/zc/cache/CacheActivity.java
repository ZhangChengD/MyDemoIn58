package com.zc.cache;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zc.mydemoin58.R;
import com.zc.util.ToastUtills;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class CacheActivity extends AppCompatActivity {

    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);
        file = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath()
                + "/VideoCache/");
        findViewById(R.id.del_cache).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delCache(file);
            }
        });
        findViewById(R.id.del_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAndDel(file, 50);
                ToastUtills.showToast(getDirectorySize(file) + "");
            }
        });
    }

    /**
     * 删除掉Cache文件
     */
    public static void delCache(File file) {
        if (file.isDirectory()) {
            final File[] children = file.listFiles();
            if (children != null)
                for (final File child : children) {
                    if (child.getName().endsWith(".cache")) {
                        child.delete();
                    }
                }
        }
    }


    /**
     * 获取当前文件夹的大小
     * 返回为字节
     */
    public long getDirectorySize(File file) {
        if (file.isFile())
            return file.length();
        final File[] children = file.listFiles();
        long total = 0;
        if (children != null)
            for (final File child : children)
                total += getDirectorySize(child);
        return total;
    }


    /**
     * 检测是否大于最大缓存如果大于则删除掉一些时间早的文件
     */
    public void checkAndDel(File file, int max) {
        if (file.isDirectory()) {
            long nowLegth = getDirectorySize(file);
            if (nowLegth > max * 1024 * 1024) {
                long moresize = nowLegth - max * 1024 * 1024;
                final File[] children = file.listFiles();
                Arrays.sort(children, new CompratorByLastModified());
                for (int i = 0; i < children.length && moresize > 0; i++) {
                    moresize -= children[i].length();
                    children[i].delete();
                }
            }
        }
    }

    class CompratorByLastModified implements Comparator<File> {
        public int compare(File f1, File f2) {
            long diff = f1.lastModified() - f2.lastModified();
            if (diff > 0)
                return 1;
            else if (diff == 0)
                return 0;
            else
                return -1;
        }

        public boolean equals(Object obj) {
            return true;
        }
    }

}
