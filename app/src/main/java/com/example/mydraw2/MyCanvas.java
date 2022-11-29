package com.example.mydraw2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCanvas extends View {
    private static final int[] colors = {Color.RED, Color.GREEN, Color.BLUE};
    private int colorIndex;
    private int canvasWidth;
    private int canvasHeight;

    public MyCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        colorIndex = 0;
    }

    @Override
    public void onDraw(Canvas canvas)  {
        Paint paint = new Paint();
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();
        drawCircle(canvas, paint);
        drawFrame(canvas, paint);
    }

    private void drawCircle(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(colors[colorIndex]);
        int centerX = canvasWidth/2;
        int centerY = canvasHeight/2;
        int radius = Math.min(canvasWidth, canvasHeight)/4;
        canvas.drawCircle(centerX, centerY, radius, paint);
    }

    private void drawFrame(Canvas canvas, Paint paint) {
        int framePadding = 20;
        int frameStrokeWidth = 5;
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(frameStrokeWidth);
        int left = framePadding;
        int top = framePadding;
        int right = canvasWidth - framePadding;
        int bottom = canvasHeight - framePadding;
        canvas.drawRect(left, top, right, bottom, paint);
    }

    public void colorChange() {
        if (colorIndex<colors.length-1)
            colorIndex++;
        else
            colorIndex = 0;
        invalidate();
    }
}
