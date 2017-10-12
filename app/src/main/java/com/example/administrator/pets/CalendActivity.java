package com.example.administrator.pets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CalendarView;

public class CalendActivity extends AppCompatActivity {
    private int year,month,dayOfMonth;
    private CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calend);
        init();
    }
    public void init(){
        calendarView = (CalendarView)findViewById(R.id.calendarview);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int y, int m, int d) {
                Log.e("AA",year+"年"+month+"月"+dayOfMonth+"日");
                String time = year+"年"+month+"月"+dayOfMonth+"日";
//                2017年10月9日
                year = y;
                month = m;
                dayOfMonth = d;
            }
        });

    }
}
