package com.brentroptobias.intellitest;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View implements View.OnTouchListener {

    Bitmap bitmap = Bitmap.createBitmap(640, 480, Bitmap.Config.ARGB_8888);
    Path path = new Path();

    static final Paint dot = new Paint(Paint.ANTI_ALIAS_FLAG);
    float[] x = new float[50];
    float[] y = new float[50];

    static {
        dot.setStyle(Paint.Style.STROKE);
        dot.setColor(Color.RED);
        dot.setStrokeWidth(3.0f);
    }


    public DrawView(Context con, AttributeSet attrs) {
        super(con, attrs);
        this.setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("TAG", "onDraw");
        Matrix matrix = new Matrix();
        matrix.reset();
        canvas.drawBitmap(bitmap, matrix, dot);
        path.rewind();
        path.moveTo(x[0], y[0]);
        for (int i = 1; i < 50; i++) {

            path.lineTo(x[i], y[i]);
            canvas.drawPath(path, dot);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        this.invalidate();
        return true;
    }
}
