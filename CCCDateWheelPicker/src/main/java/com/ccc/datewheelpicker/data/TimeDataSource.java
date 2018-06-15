package com.ccc.datewheelpicker.data;

import com.ccc.datewheelpicker.calendar.WheelCalendar;

/**
 * Date：2018/6/15 11:11
 * <p>
 * author: ghc
 * <p>
 * 数据源的接口
 */
public interface TimeDataSource {
    int getMinYear();

    int getMaxYear();

    int getMinMonth(int currentYear);

    int getMaxMonth(int currentYear);

    int getMinDay(int year, int month);

    int getMaxDay(int year, int month);

    int getMinHour(int year, int month, int day);

    int getMaxHour(int year, int month, int day);

    int getMinMinute(int year, int month, int day, int hour);

    int getMaxMinute(int year, int month, int day, int hour);

    boolean isMinYear(int year);

    boolean isMinMonth(int year, int month);

    boolean isMinDay(int year, int month, int day);

    boolean isMinHour(int year, int month, int day, int hour);

    WheelCalendar getDefaultCalendar();
}
