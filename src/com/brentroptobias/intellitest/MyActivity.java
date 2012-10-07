package com.brentroptobias.intellitest;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import roboguice.inject.InjectView;

public class MyActivity extends RoboActivity {

    @InjectView(R.id.coordx)
    TextView tv1;
    @InjectView(R.id.coordx)
    TextView tv2;
    @InjectView(R.id.ll)
    LinearLayout ll;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tv1.setText("" + (int) event.getX());
                tv2.setText("" + (int) event.getY());
                return true;
            }
        });

    }

}
