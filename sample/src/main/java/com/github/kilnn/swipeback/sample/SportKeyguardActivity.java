package com.github.kilnn.swipeback.sample;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;

import com.github.kilnn.swipeback.ShimmerFrameLayout;
import com.github.kilnn.swipeback.SwipeBackAppCompatActivity;
import com.github.kilnn.swipeback.SwipeBackLayout;

public class SportKeyguardActivity extends SwipeBackAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        FullScreenHelper.setFullScreen(this, true, true);
        setContentView(R.layout.activity_sport_keyguard);
        SwipeBackLayout swipeBackLayout = getSwipeBackLayout();
        swipeBackLayout.setEdgeLeftFullScreen(true);
        swipeBackLayout.setScrimColor(Color.TRANSPARENT);
        swipeBackLayout.setShadow(new ColorDrawable(Color.TRANSPARENT), SwipeBackLayout.EDGE_LEFT);
        swipeBackLayout.setBackgroundDrawable(new ColorDrawable(0x99000000));
        initView();
    }

    private ShimmerFrameLayout mShimmerLayout;

    private void initView() {
        mShimmerLayout = (ShimmerFrameLayout) findViewById(R.id.shimmer_layout);
        mShimmerLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                mShimmerLayout.startShimmerAnimation();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mShimmerLayout.stopShimmerAnimation();
    }

    @Override
    public boolean translucentActivity() {
        return false;
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }
}
