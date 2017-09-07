package com.example.testviewpager;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by chengjian on 2017/8/22.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private static final String TAG = "ViewPager_Adapter";
    List<View> viewLists;

    public ViewPagerAdapter(List<View> lists) {
        viewLists = lists;
    }

    @Override
    public int getCount() {
        //获得size
        return viewLists.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        Exception exception = new Exception("isViewFromObject");
//        exception.printStackTrace();
//        Log.d(TAG, "isViewFromObject: arg0=" + arg0 + "  arg1=" + arg1/*, exception*/);
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.d(TAG, "destroyItem: container=" + container + "  position=" + position + " object="
                + object);
        container.removeView(viewLists.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d(TAG, "instantiateItem: container=" + container + "  position=" + position);
        container.addView(viewLists.get(position), 0);
        return viewLists.get(position);
    }

}
