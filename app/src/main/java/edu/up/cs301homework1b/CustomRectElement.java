package edu.up.cs301homework1b;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * @Joseph Kolattukudy
 * @11/21- Homework1B
 * Class: CustomRectElement
 */
public class CustomRectElement extends CustomElement {
    private float left, top, right, bottom;

    public CustomRectElement(String name, int color, float left, float top, float right, float bottom) {
        super(name, color);
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    @Override
    public void drawSelf(Canvas canvas, Paint paint) {
        paint.setColor(this.color);
        canvas.drawRect(left, top, right, bottom, paint);
    }

    @Override
    public boolean isInside(float x, float y) {
        return x >= left && x <= right && y >= top && y <= bottom;
    }
}
