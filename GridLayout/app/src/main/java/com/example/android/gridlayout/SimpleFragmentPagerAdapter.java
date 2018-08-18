package com.example.android.gridlayout;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by DENNIS on 11/8/2017.
 */

class SimpleFragmentPagerAdapter extends FragmentPagerAdapter{
    private Context mContext;
    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new AnimalFragment();
        }else {
            return new AnimalFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return mContext.getString(R.string.animals_activity);

        }else {
            return mContext.getString(R.string.animals_activity);
        }

    }
}
