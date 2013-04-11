package com.funnycodes.android.SJCalendar;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import com.funnycodes.android.SJCalendar.Model.DataManager;
import com.funnycodes.android.SJCalendar.Model.Month;

import java.text.NumberFormat;

/**
 * Created with IntelliJ IDEA.
 * User: dimich
 * Date: 4/11/13
 * Time: 3:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class DetailsActivity extends Activity {
    private int currentMonth = 0;
    private NumberFormat nf = NumberFormat.getInstance();
    private Typeface tf;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.details);

        nf.setGroupingUsed(true);
        nf.setMinimumFractionDigits(0);
        nf.setMaximumFractionDigits(1);

        tf = Typeface.createFromAsset(getAssets(), "ProximaNova-Xbold.otf");

        TableLayout monthTable = (TableLayout)findViewById(R.id.month_calcs);
        TableLayout quartTable = (TableLayout)findViewById(R.id.quart_calcs);
        TableLayout halfTable = (TableLayout)findViewById(R.id.half_calcs);
        TableLayout yearTable = (TableLayout)findViewById(R.id.year_calcs);

        currentMonth = getIntent().getIntExtra("month", 0);

        updateMonth(monthTable);
        updateGroup(quartTable, 3, "квартал");
        updateGroup(halfTable, 6, "полугодие");
        updateGroup(yearTable, 12, null);

        View panel = findViewById(R.id.panel);
        panel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void updateMonth(TableLayout layout)
    {
        TextView table_title = (TextView)layout.findViewById(R.id.table_title);

        TextView calend = (TextView)layout.findViewById(R.id.calend);
        TextView work = (TextView)layout.findViewById(R.id.work);
        TextView dayoff = (TextView)layout.findViewById(R.id.dayoff);
        TextView day40hr = (TextView)layout.findViewById(R.id.day40hr);
        TextView day36hr = (TextView)layout.findViewById(R.id.day36hr);
        TextView day24hr = (TextView)layout.findViewById(R.id.day24hr);

        calend.setTypeface(tf);
        work.setTypeface(tf);
        dayoff.setTypeface(tf);
        day40hr.setTypeface(tf);
        day36hr.setTypeface(tf);
        day24hr.setTypeface(tf);

        Month month = DataManager.getInstance().getMonthes()[currentMonth];

        table_title.setText(month.getName());

        calend.setText(nf.format(month.getCalend()));
        work.setText(nf.format(month.getWork()));
        dayoff.setText(nf.format(month.getDayoff()));
        day40hr.setText(nf.format(month.getDay40hr()));
        day36hr.setText(nf.format(month.getDay36hr()));
        day24hr.setText(nf.format(month.getDay24hr()));

    }

    private void updateGroup(TableLayout layout, int numberOfMonthes, String titlePostfix)
    {
        TextView table_title = (TextView)layout.findViewById(R.id.table_title);

        TextView calend = (TextView)layout.findViewById(R.id.calend);
        TextView work = (TextView)layout.findViewById(R.id.work);
        TextView dayoff = (TextView)layout.findViewById(R.id.dayoff);
        TextView day40hr = (TextView)layout.findViewById(R.id.day40hr);
        TextView day36hr = (TextView)layout.findViewById(R.id.day36hr);
        TextView day24hr = (TextView)layout.findViewById(R.id.day24hr);

        calend.setTypeface(tf);
        work.setTypeface(tf);
        dayoff.setTypeface(tf);
        day40hr.setTypeface(tf);
        day36hr.setTypeface(tf);
        day24hr.setTypeface(tf);

        int currentQuartal  = (currentMonth / numberOfMonthes) + 1;
        if(titlePostfix != null)
            table_title.setText(String.valueOf(currentQuartal) + " " + titlePostfix);
        else
            table_title.setText("2013 год");

        float week40 = 0.0f;
        float week36 = 0.0f;
        float week24 = 0.0f;

        int totalDays = 0;
        int totalWorkDays = 0;
        int totalHolidays = 0;

        Month[] monthes = DataManager.getInstance().getMonthes();
        for(int i=0; i < monthes.length; ++i)
        {
            int monthQuart  = (i / numberOfMonthes) + 1;

            if(monthQuart != currentQuartal)
                continue;

            Month m = monthes[i];

            totalDays += m.getCalend();
            totalWorkDays += m.getWork();
            totalHolidays += m.getDayoff();

            week40 += m.getDay40hr();
            week36 += m.getDay36hr();
            week24 += m.getDay24hr();
        }

        calend.setText(nf.format(totalDays));
        work.setText(nf.format(totalWorkDays));
        dayoff.setText(nf.format(totalHolidays));
        day40hr.setText(nf.format(week40));
        day36hr.setText(nf.format(week36));
        day24hr.setText(nf.format(week24));

    }
}