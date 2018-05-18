package com.zc.toptab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by 张程 on 17/4/18.
 */

public class TabTopAdapter extends FragmentPagerAdapter {
    public TabTopAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (0 == position) {
            fragment = TabTopFragment.newInstance();
        } else if (1 == position) {
            fragment = TabTopFragment2.newInstance();
        } else if (2 == position) {
            fragment = TabTopFragment.newInstance();
        } else if (3 == position) {
            fragment = TabTopFragment.newInstance();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "TAB 1";
            case 1:
                return "TAB 2";
            case 2:
                return "TAB 3";
            case 3:
                return "TAB 4";
        }
        return null;
    }

}
