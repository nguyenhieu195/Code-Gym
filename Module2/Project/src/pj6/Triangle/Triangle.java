package pj6.Triangle;

public class Triangle extends Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(String color, Double side1, Double side2, Double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return area;
    }

    public double getPerimeter() {
        double perimeter = (side1 + side2 + side3);
        return perimeter;
    }

    @Override
    public String toString() {
        return "Triangle{" + "side1= " + side1 + ", side2= " + side2 + ", side3= " + side3 + ", color= " + getColor() + ", Area= " + getArea() + ", Perimeter= " + getPerimeter() + '}';
    }
}


