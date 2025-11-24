package edu.up.cs301homework1b;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * @Joseph Kolattukudy
 * @11/21- Homework1B
 * Class: CustomElement
 */
public abstract class CustomElement {
    protected String name;
    protected int color;

    public CustomElement(String name, int initialColor) {
        this.name = name;
        this.color = initialColor;
    }

    public abstract void drawSelf(Canvas canvas, Paint paint);
    public abstract boolean isInside(float x, float y);

    public String getName() {
        return this.name;
    }
    public int getColor() {
        return this.color;
    }
    public void setColor(int color) {
        this.color = color;
    }
}
