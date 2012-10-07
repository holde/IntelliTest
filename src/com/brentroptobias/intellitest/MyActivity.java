package com.brentroptobias.intellitest;

import roboguice.activity.RoboActivity;

public class MyActivity extends RoboActivity {

    @InjectView(R.id.coordx)
    private TextView tv1;
    @InjectView(R.id.coordx)
    private TextView tv2;
    @InjectView(R.id.ll)
    private LinearLayout ll;

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
