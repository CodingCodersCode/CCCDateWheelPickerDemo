package com.ccc.datewheelpicker.adapter;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

/**
 * Date：2018/6/15 11:15
 * <p>
 * author: ghc
 * <p>
 * 抽象滚轮适配器
 */
public abstract class AbstractWheelAdapter implements WheelViewAdapter {
    private List<DataSetObserver> mDatasetObservers; // 数据集观察者

    @Override
    public View getEmptyItem(View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        if (mDatasetObservers == null) {
            mDatasetObservers = new LinkedList<>();
        }
        mDatasetObservers.add(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        if (mDatasetObservers != null) {
            mDatasetObservers.remove(observer);
        }
    }

    /**
     * 通知观察者数据改变
     */
    protected void notifyDataChangedEvent() {
        if (mDatasetObservers != null) {
            for (DataSetObserver observer : mDatasetObservers) {
                observer.onChanged();
            }
        }
    }

    /**
     * 通知观察者无效数据
     */
    protected void notifyDataInvalidatedEvent() {
        if (mDatasetObservers != null) {
            for (DataSetObserver observer : mDatasetObservers) {
                observer.onInvalidated();
            }
        }
    }

}
