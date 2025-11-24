package edu.up.cs301homework1b;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @Joseph Kolattukudy
 * @11/21- Homework1B
 * Class: DrawingModel
 */
public class DrawingModel {
    private List<CustomElement> elements = new ArrayList<>();
    private CustomElement selectedElement = null;

    private static final int BODY_TOP = 500;
    private static final int BODY_BOTTOM = 750;
    private static final int LEFT_X = 200;
    private static final int RIGHT_X = 1300;
    private static final int CABIN_TOP = 300;
    private static final int CABIN_BOTTOM = 500;
    private static final float TIRE_RADIUS = 85;
    private static final float TIRE_CY = 750;

    public DrawingModel() {
        //Main Car Body
        elements.add(new CustomRectElement("Main Body", Color.RED,
                LEFT_X, BODY_TOP, RIGHT_X, BODY_BOTTOM));

        //Cabin
        elements.add(new CustomRectElement("Cabin/Roof", Color.GRAY,
                350, CABIN_TOP, 1150, CABIN_BOTTOM));

        //Windows
        elements.add(new CustomRectElement("Back Window", Color.rgb(50, 150, 255),
                380, CABIN_TOP + 30, 750, CABIN_BOTTOM - 30));

        elements.add(new CustomRectElement("Front Window", Color.rgb(50, 150, 255),
                780, CABIN_TOP + 30, 1120, CABIN_BOTTOM - 30));

        // 5. Left Tire
        elements.add(new CustomCircleElement("Left Tire", Color.BLACK,
                LEFT_X + 200, TIRE_CY, TIRE_RADIUS));

        //Right Tire
        elements.add(new CustomCircleElement("Right Tire", Color.BLACK,
                RIGHT_X - 200, TIRE_CY, TIRE_RADIUS));

    }

    public List<CustomElement> getElements()
    { return elements;
    }
    public CustomElement getSelectedElement()
    { return selectedElement;
    }

    public void setSelectedElement(CustomElement element) {
        this.selectedElement = element;
    }

    //apparently we need a find element method
    public CustomElement findElementAt(float x, float y) {
        //this is important since it sees what user taps
        for (int i = elements.size() - 1; i >= 0; i--) {
            CustomElement element = elements.get(i);

            if (element.isInside(x, y)) {
                return element;
            }
        }

        return null;
    }

    public void updateSelectedElementColor(int r, int g, int b) {
        if (selectedElement != null) {
            selectedElement.setColor(Color.rgb(r, g, b));
        }
    }
}