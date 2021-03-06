package com.ccc.demo.datewheelpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ccc.datewheelpicker.DateWheelPicker;
import com.ccc.datewheelpicker.data.Type;
import com.ccc.datewheelpicker.listener.OnDateSetListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final long HUNDRED_YEARS = 100L * 365 * 1000 * 60 * 60 * 24L; // 100年

    private TextView mTvTime;
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    private long mLastTime = System.currentTimeMillis(); // 上次设置的时间

    // 数据的回调
    private OnDateSetListener mOnDateSetListener = new OnDateSetListener() {
        @Override public void onDateSet(DateWheelPicker timePickerView, long milliseconds) {
            mLastTime = milliseconds;
            //String text = getDateToString(milliseconds);
            String text = dateFormat("yyyy-MM-dd", milliseconds);
            mTvTime.setText(text);



            long convertedMillis = convertTimeToLong(text);

            if (milliseconds == convertedMillis){
                printLog("****************", "转换前后结果相同===>milliseconds=" + milliseconds + ",convertedMillis=" + convertedMillis);
            }else {
                printLog("****************", "转换前后结果不同===>milliseconds=" + milliseconds + ",convertedMillis=" + convertedMillis);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView(); // 初始化View
    }

    /**
     * 显示日期
     *
     * @param view 视图
     */
    public void showDate(View view) {
        // 出生日期
        DateWheelPicker dialog = new DateWheelPicker.Builder()
                .setType(Type.ALL)
                .setTitleStringId("请选择出生日期")
                .setMinMilliseconds(System.currentTimeMillis() - HUNDRED_YEARS)
                .setMaxMilliseconds(System.currentTimeMillis())
                .setCurMilliseconds(mLastTime)
                .setDimAmount(0.5f)

                .setYearText("")

                .setCallback(mOnDateSetListener)
                .build();

        if (dialog != null) {
            if (!dialog.isAdded()) {
                dialog.show(getSupportFragmentManager(), "year_month_day");
            }
        }
    }

    // 初始化视图
    private void initView() {
        mTvTime = (TextView) findViewById(R.id.tv_time);
    }

    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }

    public String dateFormat(String format, long timeMillis) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(timeMillis);
    }

    public static Long convertTimeToLong(String time) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(time);
            return date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    private void printLog(String tag, String msg){
        Log.e(tag, msg);
    }
}
