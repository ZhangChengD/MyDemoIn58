package com.zc.classloader;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dalvik.system.PathClassLoader;
import demo.IShowHello;

import com.zc.mydemoin58.R;
import com.zc.util.ToastUtills;

import java.io.File;
import java.lang.reflect.Field;

import dalvik.system.DexClassLoader;

public class ClassLoaderTestActivity extends Activity {

    private static final String TAG = "ClassLoaderTestActivity";
    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_loader_test);
        mTextView = (TextView) findViewById(R.id.class_Loader_tx);
        mButton = (Button) findViewById(R.id.class_Loader_btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final File jarFile =
                        new File(Environment.getExternalStorageDirectory().getPath(), "demo_dex.jar");

                // 如果没有读权限,确定你在 AndroidManifest 中是否声明了读写权限
                Log.d(TAG, jarFile.canRead() + "");

                if (!jarFile.exists()) {
                    ToastUtills.showToast("file not find");
                    return;
                }

                // getCodeCacheDir() 方法在 API 21 才能使用,实际测试替换成 getExternalCacheDir() 等也是可以的
                // 只要有读写权限的路径均可
//                ClassLoader mClassLoader = new PathClassLoader(jarFile.getAbsolutePath(), getExternalCacheDir().getAbsolutePath(), getClassLoader());
                ClassLoader mClassLoader = new DexClassLoader(jarFile.getAbsolutePath(), ClassLoaderTestActivity.this.getFilesDir().getPath(), null,ClassLoaderTestActivity.this.getClassLoader());
                try {
                    // 加载 ShowHelloByEN 类
                    Class clazz = mClassLoader.loadClass("demo.ShowHelloByEN");
                    // 强转成 ISayHello, 注意 ISayHello 的包名需要和 jar 包中的
                    IShowHello iShowHello = (IShowHello) clazz.newInstance();
                    mTextView.setText(iShowHello.show());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    ToastUtills.showToast("ClassNotFoundException");
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

//    private static void injectAboveEqualApiLevel14(Context context, File patchFile, File dexDir)
//            throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
//
//        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
//        Object pathList = getPathList(pathClassLoader);
//        Object dexArray = combineArray(getDexElements(getPathList(pathClassLoader)),
//                getDexElements(getPathList(new DexClassLoader(patchFile.getAbsolutePath(), dexDir.getAbsolutePath(), patchFile.getAbsolutePath(), context.getClassLoader()))));
//
//        setField(pathList, pathList.getClass(), "dexElements", dexArray);
//    }

    private static void setField(Object obj, Class cls, String fieldName, Object value)
            throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(fieldName);
        declaredField.setAccessible(true);
        declaredField.set(obj, value);
    }
}
