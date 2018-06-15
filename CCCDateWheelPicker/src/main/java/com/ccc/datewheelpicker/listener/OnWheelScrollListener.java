package com.ccc.datewheelpicker.listener;

import com.ccc.datewheelpicker.wheel.WheelView;

/**
 * Date：2018/6/15 11:06
 * <p>
 * author: ghc
 *
 * Wheel scrolled listener interface.
 */
public interface OnWheelScrollListener {
    /**
     * Callback method to be invoked when scrolling started.
     *
     * @param wheel the wheel view whose state has changed.
     */
    void onScrollingStarted(WheelView wheel);

    /**
     * Callback method to be invoked when scrolling ended.
     *
     * @param wheel the wheel view whose state has changed.
     */
    void onScrollingFinished(WheelView wheel);
}
