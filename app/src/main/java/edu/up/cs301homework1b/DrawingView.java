package edu.up.cs301homework1b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * @Joseph Kolattukudy
 * @11/21- Homework1B
 * Class: DrawingView
 */
public class DrawingView extends SurfaceView implements SurfaceHolder.Callback {
    private DrawingModel model;
    private DrawingController controller;
    private Paint paint = new Paint();

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
        setWillNotDraw(false);
    }

    public void setMVC(DrawingModel model, DrawingController controller) {
        this.model = model;
        this.controller = controller;
    }

    public void redraw() {
        if (getHolder().getSurface().isValid() && model != null) {
            Canvas canvas = getHolder().lockCanvas();
            if (canvas != null) {
                canvas.drawColor(Color.WHITE); //clears

                //draws all
                for (CustomElement element : model.getElements()) {
                    element.drawSelf(canvas, paint);
                }

                //unmodifyable hubcaps
                paint.setColor(Color.YELLOW);
                paint.setStyle(Paint.Style.FILL); // Ensure they are solid yellow

                // Left Hubcap (Same center as Left Tire: cx=400, cy=750)
                canvas.drawCircle(400, 750, 30, paint);

                // Right Hubcap (Same center as Right Tire: cx=1100, cy=750)
                canvas.drawCircle(1100, 750, 30, paint);
                getHolder().unlockCanvasAndPost(canvas);
            }
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        redraw();
    }
    @Override public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}
    @Override public void surfaceDestroyed(SurfaceHolder holder) {}

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (controller != null && event.getAction() == MotionEvent.ACTION_DOWN) {
            // passing the tap coordinates to the controller- yay!
            controller.handleTap(event.getX(), event.getY());
            return true;
        }
        return super.onTouchEvent(event);
    }
}
