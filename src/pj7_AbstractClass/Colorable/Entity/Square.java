package pj7_AbstractClass.Colorable.Entity;

import pj7_AbstractClass.Colorable.Service.Colorable;

import java.awt.*;

public class Square implements Colorable {
    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }

    private String color = "blue";
    private float width = 1.0f;

    @Override
    public String toString() {
        return "Square{" +
                "color='" + color + '\'' +
                ", width=" + width +
                '}';
    }

    public float getArea() {
        return width * width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public Square(String color, float width) {
        this.color = color;
        this.width = width;
    }
}
