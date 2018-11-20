package com.github.kilnn.swipeback;


/**
 * interface for {@link SwipeBackActivity}
 */
public interface SwipeBackActivityBase {
    /**
     * the SwipeBackLayout associated with this activity.
     */
    SwipeBackLayout getSwipeBackLayout();


    void setSwipeBackEnable(boolean enable);

    /**
     * Scroll out contentView and finish the activity
     */
    void scrollToFinishActivity();

    /**
     * 是否将Activity设置为透明
     *
     * @return
     */
    boolean translucentActivity();
}
