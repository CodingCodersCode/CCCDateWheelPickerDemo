package com.ccc.datewheelpicker.listener;

import com.ccc.datewheelpicker.DateWheelPicker;

/**
 * Date：2018/6/15 10:59
 * <p>
 * author: ghc
 *
 * 日期设置的监听器
 */
public interface OnDateSetListener {
    void onDateSet(DateWheelPicker timePickerView, long milliseconds);
}
