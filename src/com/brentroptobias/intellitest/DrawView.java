package com.brentroptobias.intellitest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DrawView extends View implements View.OnTouchListener {

    private static final float STROKE_WIDTH = 5f;

    List<Point> points = new ArrayList<Point>();
    Paint paint = new Paint();
    boolean first = true;

    public DrawView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(true);
        setFocusableInTouchMode(true);

        this.setOnTouchListener(this);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(STROKE_WIDTH);
        paint.setColor(Color.WHITE);
    }

    @Override
    public void onDraw(Canvas canvas) {
        Path path = new Path();
        for (Point point : points) {
            if (first) {
                first = false;
                path.moveTo(point.x, point.y);
            } else {
                path.lineTo(point.x, point.y);
            }
        }

        canvas.drawPath(path, paint);
    }

    public boolean onTouch(View view, MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_UP) {
            for (int i = 0; i < event.getHistorySize(); i++) {
                Point point = new Point();
                point.x = event.getHistoricalX(i);
                point.y = event.getHistoricalY(i);
                points.add(point);
            }
            invalidate();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            first = true;
        }
        return super.onTouchEvent(event);
    }

    public void clear() {
        points.clear();
    }

    class Point {
        float x, y;
        float dx, dy;

        @Override
        public String toString() {
            return x + ", " + y;
        }
    }
}
