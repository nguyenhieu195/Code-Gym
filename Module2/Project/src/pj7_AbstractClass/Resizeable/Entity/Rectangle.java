package pj7_AbstractClass.Resizeable.Entity;

import pj7_AbstractClass.Resizeable.Service.Resizeable;

public class Rectangle implements Resizeable {
    @Override
    public void resize(double percent) {
        width += width * percent / 100.0;
        length += length * percent / 100.0;
    }

    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getAra() {
        return this.width * this.length;
    }

    public double getPerimeter() {
        return (this.width + this.length) * 2;
    }

    @Override
    public String toString() {
        return "A Rectangle with width= " + this.width + " and length= " + this.length + ", which is a subclass of " + super.toString();
    }
}
