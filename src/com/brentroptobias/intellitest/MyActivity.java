package com.brentroptobias.intellitest;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyActivity extends Activity {

    TextView tv1, tv2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv1 = (TextView) findViewById(R.id.xcoord);
        tv2 = (TextView) findViewById(R.id.ycoord);
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
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
