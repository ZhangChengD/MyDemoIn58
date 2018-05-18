package com.zc.mydemoin58;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zc.util.ToastUtills;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("sdads");
        ClassLoader loader = MainActivity.class.getClassLoader();
        while (loader != null) {
            Log.e("loader--", loader.toString());
            loader = loader.getParent();
        }
    }

    @Override
    public void onClick(View v) {
        int type = v.getId();
        switch (type) {
            case R.id.gotoSynch:
                jump("com.zc.synch.SynchActivity");
                break;
            case R.id.gotoStatusBar:
                jump("com.zc.statusbar.StatusBarActivity");
                break;
            case R.id.gotoSetting:
                jump("com.zc.setting.SettingActivity");
                break;
            case R.id.gotoDesign:
                jump("com.zc.design.DesignActivity");
                break;
            case R.id.gotoFloating:
                jump("com.zc.floating.FloatingActivity");
                break;
            case R.id.gotoNest:
                jump("com.zc.nest.NestActivity");
                break;
            case R.id.gotoViewPager:
                jump("com.zc.viewpager.MyViewPagerActivity");
                break;
            case R.id.gotoRecyclerView:
                jump("com.zc.recylerview.FansActivity");
                break;
            case R.id.gotoHorRecyclerView:
                jump("com.zc.recylerview.HorReclyerActivity");
                break;
            case R.id.gotoBitmap:
                jump("com.zc.mbitmap.BitmapActivity");
                break;
            case R.id.gotoFlow:
                jump("com.zc.flow.FlowActivity");
                break;
            case R.id.gotoShake:
                jump("com.zc.shake.ShakeActivity");
                break;
            case R.id.gotoTabTop:
                jump("com.zc.toptab.TabTopActivity");
                break;
            case R.id.gotoTabTop2:
                jump("com.zc.tabtop2.TabTop2Activity");
                break;
            case R.id.gotoLV:
                jump("com.zc.constrainlay.ConstraintLayoutActivity");
                break;
            case R.id.gotoMoveView:
                jump("com.zc.moveview.MoveViewByCoorLayActivity");
                break;
            case R.id.gotoCacheFileOpe:
                jump("com.zc.cache.CacheActivity");
                break;
            case R.id.gotoAnimation:
                jump("com.zc.anima.AnimaActivity");
                break;
            case R.id.gotoExpandLV:
                jump("com.zc.expandlv.ExpandLVActivity");
                break;
            case R.id.gotoMyView:
                jump("com.zc.viewconstructor.ViewConstructorActivity");
                break;
            case R.id.gotoConstraintLayout:
                jump("com.zc.constraintdemo.ConstraintLayActivity");
                break;
            case R.id.gotoTestDB:
                jump("com.zc.testdb.TestDBActivity");
                break;
            case R.id.gotoTestRXJava:
                jump("com.zc.RXJava.RXJavaActivity");
                break;
            case R.id.gotoTestIVReclcy:
                jump("com.zc.ivReclcy.TestIvReclcyActivity");
                break;
            case R.id.gotoDemoImageLeak:
                jump("com.zc.demoImage.DemoImageLeakActivity");
                break;
            case R.id.gotoModuleMain:
                jump("com.example.aarmodule.ModuleMainActivity");
                break;
            case R.id.gotoGlideMain:
                jump("com.zc.glide.GlideMainActivity");
                break;
            case R.id.gotoClassLoaderTest:
                jump("com.zc.classloader.ClassLoaderTestActivity");
                break;
            case R.id.gotoTestActivity:
                jump("com.zc.testactivity.TestActivity");
                break;
            case R.id.gotoMultiView:
                jump("com.zc.multi.MultiViewFirstActivity");
                break;
            case R.id.gotoSlidingMenu:
                jump("com.zc.slidingmenu.SlidingMenuActivity");
                break;
            case R.id.gotoSQlTest:
                jump("com.zc.sql.SqlTestActivity");
                break;
        }
    }

    public void jump(String activityname) {
        try {
            Class clazz = Class.forName(activityname);
            Intent intent = new Intent(MainActivity.this, clazz);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            ToastUtills.showToast("类名跳转错误");
        }
    }
}
