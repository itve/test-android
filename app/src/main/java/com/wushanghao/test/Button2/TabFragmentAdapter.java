package com.wushanghao.test.Button2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabFragmentAdapter extends FragmentPagerAdapter {
    public TabFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        Fragment fragment = new Fragment();
        switch (i){
            case 0:
                fragment = new AttentionFragment();
                break;
            case 1:
                fragment = new RecommendFragment();
                break;
            case 2:
                fragment = new OrdinaryFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        //三个Fragment
        return 3;
    }
}
