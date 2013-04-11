package com.funnycodes.android.SJCalendar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.funnycodes.android.SJCalendar.Model.DataManager;
import com.funnycodes.android.SJCalendar.Model.Month;

import java.text.NumberFormat;

public class MainActivity extends Activity {

    private int[] pagerResIds = new int[12];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        pagerResIds = new int[]{R.drawable.m1, R.drawable.m2, R.drawable.m3
                , R.drawable.m4, R.drawable.m5, R.drawable.m6, R.drawable.m7
                , R.drawable.m8, R.drawable.m9, R.drawable.m10, R.drawable.m11
                , R.drawable.m12};

        final TextView monthTitle = (TextView)findViewById(R.id.month_title);
        final TextView detailsMonthName = (TextView)findViewById(R.id.details_month_name);

        final TextView calend = (TextView)findViewById(R.id.calend);
        final TextView work = (TextView)findViewById(R.id.work);
        final TextView dayoff = (TextView)findViewById(R.id.dayoff);
        final TextView day40hr = (TextView)findViewById(R.id.day40hr);
        final TextView day36hr = (TextView)findViewById(R.id.day36hr);
        final TextView day24hr = (TextView)findViewById(R.id.day24hr);

        final TextView nvText = (TextView)findViewById(R.id.navi_text);

        Typeface tf = Typeface.createFromAsset(getAssets(), "ProximaNova-Xbold.otf");
        calend.setTypeface(tf);
        work.setTypeface(tf);
        dayoff.setTypeface(tf);
        day40hr.setTypeface(tf);
        day36hr.setTypeface(tf);
        day24hr.setTypeface(tf);

        monthTitle.setTypeface(tf);

        final HorizontalPager pager = (HorizontalPager)findViewById(R.id.horizontal_pager);

        pager.setOnScreenSwitchListener(new HorizontalPager.OnScreenSwitchListener() {
            @Override
            public void onScreenSwitched(int screen) {

                NumberFormat nf = NumberFormat.getInstance();
                nf.setGroupingUsed(true);
                nf.setMinimumFractionDigits(0);
                nf.setMaximumFractionDigits(1);

                Month month = DataManager.getInstance().getMonthes()[screen];

                monthTitle.setText(month.getName() + " 2013");
                detailsMonthName.setText(month.getName());

                calend.setText(nf.format(month.getCalend()));
                work.setText(nf.format(month.getWork()));
                dayoff.setText(nf.format(month.getDayoff()));
                day40hr.setText(nf.format(month.getDay40hr()));
                day36hr.setText(nf.format(month.getDay36hr()));
                day24hr.setText(nf.format(month.getDay24hr()));

                int currentQuartal  = (screen / 3) + 1;
                int currentHalf = (screen / 6) + 1;

                nvText.setText(String.valueOf(currentQuartal) + " квартал, " + String.valueOf(currentHalf)
                        + " полугодие 2013 г.");
            }
        });

        View detailsPanel = findViewById(R.id.details_panel);
        detailsPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("month", pager.getCurrentScreen());
                startActivity(intent);
            }
        });

        View infoBtn = findViewById(R.id.info_btn);
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

        for(int i=0; i < 12; ++i)
        {
            ImageView img = new ImageView(this);
            LinearLayout.LayoutParams vp =
                    new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
            img.setLayoutParams(vp);
            img.setImageResource(pagerResIds[i]);

            pager.addView(img);
        }

        pager.setCurrentScreen(0,true);
    }


}
