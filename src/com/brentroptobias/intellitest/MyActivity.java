package com.brentroptobias.intellitest;

import android.os.Bundle;
import roboguice.activity.RoboActivity;

public class MyActivity extends RoboActivity {

//    private DrawView view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        view = (DrawView) findViewById(R.id.view);
//        Bitmap bitmap = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);
//        final Paint dot = new Paint();
//        final Canvas canvas = new Canvas(bitmap);
//        dot.setColor(Color.RED);
//        dot.setStrokeWidth(3.0f);
    }
}
