package edu.up.cs301homework1b;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * @Joseph Kolattukudy
 * @11/21- Homework1B
 * Class: CustomCircleElement
 */
public class CustomCircleElement extends CustomElement {
    private float cx, cy, radius;

    private float left, top, right, bottom;

    public CustomCircleElement(String name, int color, float cx, float cy, float radius) {
        super(name, color);
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;

        this.left = cx - radius;
        this.top = cy - radius;
        this.right = cx + radius;
        this.bottom = cy + radius;
    }

    @Override
    public void drawSelf(Canvas canvas, Paint paint) {
        paint.setColor(this.color);
        canvas.drawCircle(cx, cy, radius, paint); //draws circle
    }
    //checks if bounds
    @Override
    public boolean isInside(float x, float y) {
        return x >= left && x <= right && y >= top && y <= bottom;
    }
}