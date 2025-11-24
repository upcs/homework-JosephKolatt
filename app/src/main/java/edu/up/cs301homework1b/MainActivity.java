package edu.up.cs301homework1b;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get components
        DrawingModel model = new DrawingModel();
        DrawingView drawingView = findViewById(R.id.surfaceView);
        TextView elementTextView = findViewById(R.id.element_name_text);
        SeekBar redSeekBar = findViewById(R.id.red_seekbar);
        SeekBar greenSeekBar = findViewById(R.id.green_seekbar);
        SeekBar blueSeekBar = findViewById(R.id.blue_seekbar);

        //max binary for seeks
        redSeekBar.setMax(255);
        greenSeekBar.setMax(255);
        blueSeekBar.setMax(255);

        DrawingController controller = new DrawingController(
                model, drawingView, elementTextView, redSeekBar, greenSeekBar, blueSeekBar);

        // connecting view with model and crontoller
        drawingView.setMVC(model, controller);

        //seekbar
        SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //only if from user
                if (fromUser) {
                    controller.handleSeekBarChange(
                            redSeekBar.getProgress(),
                            greenSeekBar.getProgress(),
                            blueSeekBar.getProgress()
                    );
                }
            }
            //seekbar methods
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        };

        redSeekBar.setOnSeekBarChangeListener(seekBarListener);
        greenSeekBar.setOnSeekBarChangeListener(seekBarListener);
        blueSeekBar.setOnSeekBarChangeListener(seekBarListener);
    }
}