package pj6_Polymorphism;

public class Circle_Cylinder {
    public static void main(String[] args) {
        Circle circle = new Circle(5, "red");
        Cylinder cylinder = new Cylinder(5, "green", 10);

        System.out.println(circle.toString());
        System.out.println(cylinder.toString());
        System.out.println("-----------------------------");
        System.out.println("Dien tich hinh tron ban kinh " + circle.getRadius() + " la: " + circle.getArea());
        System.out.println("Thể tích hình trụ bán kính :" + cylinder.getRadius() + " chiều cao :" + cylinder.getHeight() + " la: " + cylinder.getVolume());
    }
}

class Circle {
    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + ", color='" + color + '\'' + '}';
    }
}

class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return getArea() * this.height;
    }

    @Override
    public String toString() {
        return "Cylinder{" + "height=" + height + '}';
    }
}