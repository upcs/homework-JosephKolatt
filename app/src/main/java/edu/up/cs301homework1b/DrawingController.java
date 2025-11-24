package edu.up.cs301homework1b;

import android.graphics.Color;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * @Joseph Kolattukudy
 * @11/21- Homework1B
 * Class: DrawingController
 */
public class DrawingController {
    private DrawingModel model;
    private DrawingView view;
    private TextView textView;
    private SeekBar rSeekBar, gSeekBar, bSeekBar;

    public DrawingController(DrawingModel model, DrawingView view, TextView textView,
                             SeekBar rSeekBar, SeekBar gSeekBar, SeekBar bSeekBar) {
        this.model = model;
        this.view = view;
        this.textView = textView;
        this.rSeekBar = rSeekBar;
        this.gSeekBar = gSeekBar;
        this.bSeekBar = bSeekBar;
    }

    public void handleTap(float x, float y) {
        CustomElement tappedElement = model.findElementAt(x, y);

        if (tappedElement != null) {
            model.setSelectedElement(tappedElement);

            //update textview
            textView.setText(tappedElement.getName());

            //update seekbars
            int color = tappedElement.getColor();
            rSeekBar.setProgress(Color.red(color));
            gSeekBar.setProgress(Color.green(color));
            bSeekBar.setProgress(Color.blue(color));

            view.redraw();
        }
    }

    public void handleSeekBarChange(int r, int g, int b) {
        // change color of the selected element- whole assignment
        model.updateSelectedElementColor(r, g, b);
        view.redraw();
    }
}
