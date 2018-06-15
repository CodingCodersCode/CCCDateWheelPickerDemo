package com.ccc.datewheelpicker.listener;

import com.ccc.datewheelpicker.wheel.WheelView;

/**
 * Date：2018/6/15 11:06
 * <p>
 * author: ghc
 *
 * Wheel clicked listener interface.
 * The onItemClicked() method is called whenever a wheel item is clicked
 * New Wheel position is set
 * Wheel view is scrolled
 */
public interface OnWheelClickedListener {
    /**
     * Callback method to be invoked when current item clicked
     *
     * @param wheel     the wheel view
     * @param itemIndex the index of clicked item
     */
    void onItemClicked(WheelView wheel, int itemIndex);
}
