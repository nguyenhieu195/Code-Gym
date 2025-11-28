package pj7_AbstractClass.Resizeable.Entity;

import pj7_AbstractClass.Resizeable.Service.Resizeable;

public class Circle implements Resizeable {
    @Override
    public void resize(double percent) {
        radius += radius * percent / 100.0;
    }

    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getAra() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return "A Circle with radius= " + this.radius + ", which is a subclass of  " + super.toString();
    }
}
