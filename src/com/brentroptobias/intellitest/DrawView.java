package com.brentroptobias.intellitest;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View implements View.OnTouchListener {

    private static final float STROKE_WIDTH = 10f;

    Paint paint = new Paint();
    Path path = new Path();
    RectF rect = new RectF(0, 0, 0, 0);
    float l = 0, t = 0, r = 0, b = 0;

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
        canvas.drawPath(path, paint);
    }


    public boolean onTouch(View view, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_MOVE:

                l = x;
                r = x;
                t = y;
                b = y;
                for (int i = 0; i < event.getHistorySize(); i++) {
                    float newX = event.getHistoricalX(i);
                    float newY = event.getHistoricalY(i);
                    path.lineTo(newX, newY);
                    l = newX < l ? newX : l;
                    t = newY < t ? newY : t;
                    r = newX > r ? newX : r;
                    b = newY > b ? newY : b;
                }
                rect.set(l, t, r, b);
                Log.d("TAG", rect.toShortString());
                invalidate((int) rect.left - 5, (int) rect.top - 5, (int) rect.right + 5, (int) rect.bottom + 5);
                break;
            default:
        }
        return super.onTouchEvent(event);
    }

}
