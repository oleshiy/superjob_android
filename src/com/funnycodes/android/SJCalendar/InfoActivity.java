package com.funnycodes.android.SJCalendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created with IntelliJ IDEA.
 * User: dimich
 * Date: 4/11/13
 * Time: 7:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class InfoActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.info);

        View panel = findViewById(R.id.panel);
        panel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}