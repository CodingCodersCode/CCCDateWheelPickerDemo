package com.ccc.datewheelpicker.calendar;

import java.util.Calendar;

/**
 * Date：2018/6/15 10:56
 * <p>
 * author: ghc
 *
 * 滚轮日期, 通过秒转换时间数据
 */
public class WheelCalendar {
    public int year, month, day, hour, minute;

    private boolean mNoRange; // 是否含有数据

    public WheelCalendar(long milliseconds) {
        initData(milliseconds);
    }

    private void initData(long milliseconds) {
        if (milliseconds == 0) {
            mNoRange = true;
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTimeInMillis(milliseconds);

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
    }

    public boolean isNoRange() {
        return mNoRange;
    }
}
