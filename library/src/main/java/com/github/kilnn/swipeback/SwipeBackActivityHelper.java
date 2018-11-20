package com.github.kilnn.swipeback;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;


/**
 *
 */
public class SwipeBackActivityHelper {
    private Activity mActivity;

    private SwipeBackLayout mSwipeBackLayout;
    private boolean mTranslucentActivity;

    public SwipeBackActivityHelper(Activity activity, boolean translucentActivity) {
        mActivity = activity;
        mTranslucentActivity = translucentActivity;
    }

    @SuppressWarnings("deprecation")
    public void onActivityCreate() {
        mActivity.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mActivity.getWindow().getDecorView().setBackgroundDrawable(null);
        mSwipeBackLayout = (SwipeBackLayout) LayoutInflater.from(mActivity).inflate(R.layout.layout_swipe_back, null);
        if (mTranslucentActivity) {
            mSwipeBackLayout.addSwipeListener(new SwipeBackLayout.SwipeListener() {
                @Override
                public void onScrollStateChange(int state, float scrollPercent) {
                }

                @Override
                public void onEdgeTouch(int edgeFlag) {
                    Utils.convertActivityToTranslucent(mActivity);
                }

                @Override
                public void onScrollOverThreshold() {

                }
            });
        }
    }

    public void onPostCreate() {
        mSwipeBackLayout.attachToActivity(mActivity);
    }

    public View findViewById(int id) {
        if (mSwipeBackLayout != null) {
            return mSwipeBackLayout.findViewById(id);
        }
        return null;
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return mSwipeBackLayout;
    }
}
