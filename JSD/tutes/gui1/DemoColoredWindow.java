package tutes.gui1;

import java.awt.Color;
import java.awt.Point;

public class DemoColoredWindow {
    public static void main(String[] args) {
        // create one window with default background colour
        ColoredWindow w1 = new ColoredWindow("Default window");
        w1.setVisible(true);

        // create another window with yellow background colour
        ColoredWindow w2 = new ColoredWindow("Yellow window", Color.YELLOW);
        w2.setVisible(true);

        // change location of second window relative to the first
        Point p = w1.getLocation();
        int offset = 50;
        int x2 = (int) (p.getX() + offset);
        int y2 = (int) (p.getY() + offset);
        w2.setLocation(x2, y2);
    }
}