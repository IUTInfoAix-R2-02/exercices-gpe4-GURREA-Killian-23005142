package fr.amu.iut.exercice5;

import javafx.scene.shape.Rectangle;

public class Obstacles extends Rectangle {
    private Rectangle rectangle;
    public Obstacles(double height, double width, double x, double y) {
        super(x, y, width, height);
    }
}
