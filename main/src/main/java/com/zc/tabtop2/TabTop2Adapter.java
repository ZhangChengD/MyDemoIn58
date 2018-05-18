package com.zc.tabtop2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.zc.util.ToastUtills;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张程 on 17/4/21.
 */

public class TabTop2Adapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    private void initFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new TapTop2Fragment());
        fragmentList.add(new TapTop2Fragment());
        fragmentList.add(new TapTop2Fragment());
    }

    public TabTop2Adapter(FragmentManager fm) {
        super(fm);
        initFragment();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        ToastUtills.showToast("现在在" + position);
        super.setPrimaryItem(container, position, object);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
